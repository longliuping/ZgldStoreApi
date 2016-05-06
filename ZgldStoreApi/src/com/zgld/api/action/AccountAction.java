package com.zgld.api.action;

import com.zgld.api.beans.BalanceDetails;
import com.zgld.api.beans.BalanceDrawRequest;
import com.zgld.api.beans.UserProfile;
import com.zgld.api.beans.YAccount;
import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AccountAction extends BaseAction {
	/**
	 * 收入明细
	 * 
	 * @return
	 */
	public String find_inpour_request() {
		Map json = new HashMap();
		try {
			YAccount account = getUserInfo();
			if (account != null) {
				int userId = account.getUsers().getUserId().intValue();
				List listInfo = this.baseService.findPage(this.form.getPageNum().intValue(),
						this.form.getPageSize().intValue(),
						" from InpourRequest as hsc where hsc.userId = " + userId + " order by hsc.tradeDate desc ");
				json.put(LISTINFO, listInfo);
				this.form.setJsonMsg("success", true, json, 200);
			}
		} catch (Exception e) {
			e.printStackTrace();
			this.form.setJsonMsg(SYS_RUN_ERROR, false, json, 1001);
		}
		return JSON_PAGE;
	}

	/**
	 * 积分详细
	 * 
	 * @return
	 */
	public String find_point_details() {
		Map json = new HashMap();
		try {
			YAccount account = getUserInfo();
			if (account != null) {
				int userId = account.getUsers().getUserId().intValue();
				List listInfo = this.baseService.findPage(this.form.getPageNum().intValue(),
						this.form.getPageSize().intValue(),
						" from PointDetails as hsc where hsc.userId = " + userId + " order by hsc.tradeDate desc ");
				json.put(LISTINFO, listInfo);
				this.form.setJsonMsg("success", true, json, 200);
			}
		} catch (Exception e) {
			e.printStackTrace();
			this.form.setJsonMsg(SYS_RUN_ERROR, false, json, 1001);
		}
		return JSON_PAGE;
	}

	/**
	 * 充值明细
	 */
	public String find_balance_details() {
		Map json = new HashMap();
		try {
			YAccount account = getUserInfo();
			if (account != null) {
				int userId = account.getUsers().getUserId().intValue();
				List listInfo = this.baseService.findPage(this.form.getPageNum().intValue(),
						this.form.getPageSize().intValue(),
						" from BalanceDetails as hsc where hsc.userId = " + userId + " order by hsc.tradeDate desc ");
				json.put(LISTINFO, listInfo);
				this.form.setJsonMsg("success", true, json, 200);
			}
		} catch (Exception e) {
			e.printStackTrace();
			this.form.setJsonMsg(SYS_RUN_ERROR, false, json, 1001);
		}
		return JSON_PAGE;
	}

	/**
	 * 提现明细
	 * 
	 * @return
	 */
	public String find_balance_draw_request() {
		Map json = new HashMap();
		try {
			YAccount account = getUserInfo();
			if (account != null) {
				int userId = account.getUsers().getUserId().intValue();
				List listInfo = this.baseService.findPage(this.form.getPageNum().intValue(),
						this.form.getPageSize().intValue(), " from BalanceDrawRequest as hsc where hsc.userId = "
								+ userId + " order by hsc.requestTime desc ");
				json.put(LISTINFO, listInfo);
				this.form.setJsonMsg("success", true, json, 200);
			}
		} catch (Exception e) {
			e.printStackTrace();
			this.form.setJsonMsg(SYS_RUN_ERROR, false, json, 1001);
		}
		return JSON_PAGE;
	}

	/**
	 * 冻结明细
	 * 
	 * @return
	 */
	public String find_balance_freeze_details() {
		Map json = new HashMap();
		try {
			YAccount account = getUserInfo();
			if (account != null) {
				int userId = account.getUsers().getUserId().intValue();

				List listInfo = this.baseService.findPage(this.form.getPageNum().intValue(),
						this.form.getPageSize().intValue(), " from BalanceFreezeDetails as hsc where hsc.userId = "
								+ userId + " order by hsc.freezeTime desc ");
				json.put(LISTINFO, listInfo);
				this.form.setJsonMsg("success", true, json, 200);
			}
		} catch (Exception e) {
			e.printStackTrace();
			this.form.setJsonMsg(SYS_RUN_ERROR, false, json, 1001);
		}
		return JSON_PAGE;
	}

	/**
	 * 用户申请提现
	 * 
	 * @return
	 */
	public String user_apply_withdrawal() {
		Map json = new HashMap();
		try {
			YAccount account = getUserInfo();
			Double balance = 0.0D;
			if (account != null) {
				balance = account.getUserProfile().getBalance();
				if ((this.form.getAmount() == null) || (this.form.getAmount().doubleValue() <= 0.0D) || balance == null
						|| balance <= 0.0D || balance < form.getAmount()) {
					this.form.setJsonMsg("账户余额为" + balance + "，不能申请提现!", false, json, 1001);
				} else {
					int userId = account.getUsers().getUserId().intValue();
					BalanceDrawRequest req = new BalanceDrawRequest();
					req.setRequestTime(new Date());
					req.setUserId(Integer.valueOf(userId));
					req.setRequestStatus(Integer.valueOf(0));
					req.setAmount(this.form.getAmount());
					req.setRemark(this.form.getRemark());
					this.baseService.save(req);
					UserProfile up = account.getUserProfile();
					up.setBalance(up.getBalance() - form.getAmount());
					baseService.update(up);
					json.put(INFO, account);
					this.form.setJsonMsg("申请成功，等待审核!", true, json, 200);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			this.form.setJsonMsg(SYS_RUN_ERROR, false, json, 1001);
		}
		return JSON_PAGE;
	}

	/**
	 * 在线充值 生成充值
	 * 
	 * @return
	 */
	public String user_recharge() {
		Map json = new HashMap();
		try {
			YAccount account = getUserInfo();
			if (account != null) {
				if ((this.form.getAmount() == null) || (this.form.getAmount().doubleValue() <= 0.0D)) {
					this.form.setJsonMsg("amount不能为空", false, json, 1001);
				} else {
					int userId = account.getUsers().getUserId().intValue();
					BalanceDetails req = new BalanceDetails();
					req.setTradeDate(new Date());
					req.setUserId(Integer.valueOf(userId));
					// req.setIncome(this.form.getAmount());
					req.setBalance(form.getAmount());
					req.setRemark(this.form.getRemark());
					Serializable id = this.baseService.save(req);
					// BalanceDetails info = (BalanceDetails) this.baseService
					// .bean(" from BalanceDetails as b where b.balanceId = " +
					// id.toString());
					// json.put(INFO, info);
					json.put(INFO, getAlipayconfig("在线充值", "用户使用手机端充值", 0.0D, form.getAmount(), "ZXCZ" + id.toString(),
							"http://115.28.20.167:8090/webapi/notify_url2.jsp"));
					this.form.setJsonMsg("提交成功，请充值!", true, json, 200);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			this.form.setJsonMsg(SYS_RUN_ERROR, false, json, 1001);
		}
		return JSON_PAGE;
	}
}