package com.zgld.api.action;
import com.zgld.api.beans.BalanceDetails;
import com.zgld.api.beans.BalanceDrawRequest;
import com.zgld.api.beans.YAccount;
import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AccountAction extends BaseAction {
	public String find_inpour_request() {
		Map json = new HashMap();
		try {
			YAccount account = getUserInfo();
			if (account == null) {
				this.form.setJsonMsg(NO_USER, false, json, 201);
			} else {
				int userId = account.getUsers().getUserId().intValue();

				List listInfo = this.baseService.findPage(this.form.getPageNum().intValue(),
						this.form.getPageSize().intValue(), " from InpourRequest as hsc where hsc.userId = " + userId);
				json.put("listInfo", listInfo);
				this.form.setJsonMsg("success", true, json, 200);
			}
		} catch (Exception e) {
			e.printStackTrace();
			this.form.setJsonMsg(SYS_RUN_ERROR, false, json, 1001);
		}
		return "jsonPage";
	}

	public String find_point_details() {
		Map json = new HashMap();
		try {
			YAccount account = getUserInfo();
			if (account == null) {
				this.form.setJsonMsg(NO_USER, false, json, 201);
			} else {
				int userId = account.getUsers().getUserId().intValue();

				List listInfo = this.baseService.findPage(this.form.getPageNum().intValue(),
						this.form.getPageSize().intValue(), " from PointDetails as hsc where hsc.userId = " + userId);
				json.put("listInfo", listInfo);
				this.form.setJsonMsg("success", true, json, 200);
			}
		} catch (Exception e) {
			e.printStackTrace();
			this.form.setJsonMsg(SYS_RUN_ERROR, false, json, 1001);
		}
		return "jsonPage";
	}

	public String find_balance_details() {
		Map json = new HashMap();
		try {
			YAccount account = getUserInfo();
			if (account == null) {
				this.form.setJsonMsg(NO_USER, false, json, 201);
			} else {
				int userId = account.getUsers().getUserId().intValue();

				List listInfo = this.baseService.findPage(this.form.getPageNum().intValue(),
						this.form.getPageSize().intValue(), " from BalanceDetails as hsc where hsc.userId = " + userId);
				json.put("listInfo", listInfo);
				this.form.setJsonMsg("success", true, json, 200);
			}
		} catch (Exception e) {
			e.printStackTrace();
			this.form.setJsonMsg(SYS_RUN_ERROR, false, json, 1001);
		}
		return "jsonPage";
	}

	public String find_balance_draw_request() {
		Map json = new HashMap();
		try {
			YAccount account = getUserInfo();
			if (account == null) {
				this.form.setJsonMsg(NO_USER, false, json, 201);
			} else {
				int userId = account.getUsers().getUserId().intValue();

				List listInfo = this.baseService.findPage(this.form.getPageNum().intValue(),
						this.form.getPageSize().intValue(),
						" from BalanceDrawRequest as hsc where hsc.userId = " + userId);
				json.put("listInfo", listInfo);
				this.form.setJsonMsg("success", true, json, 200);
			}
		} catch (Exception e) {
			e.printStackTrace();
			this.form.setJsonMsg(SYS_RUN_ERROR, false, json, 1001);
		}
		return "jsonPage";
	}

	public String find_balance_freeze_details() {
		Map json = new HashMap();
		try {
			YAccount account = getUserInfo();
			if (account == null) {
				
				this.form.setJsonMsg(NO_USER, false, json, 201);
			} else {
				int userId = account.getUsers().getUserId().intValue();

				List listInfo = this.baseService.findPage(this.form.getPageNum().intValue(),
						this.form.getPageSize().intValue(),
						" from BalanceFreezeDetails as hsc where hsc.userId = " + userId);
				json.put("listInfo", listInfo);
				this.form.setJsonMsg("success", true, json, 200);
			}
		} catch (Exception e) {
			e.printStackTrace();
			this.form.setJsonMsg(SYS_RUN_ERROR, false, json, 1001);
		}
		return "jsonPage";
	}

	public String user_apply_withdrawal() {
		Map json = new HashMap();
		try {
			YAccount account = getUserInfo();
			if (account == null) {
				this.form.setJsonMsg(NO_USER, false, json, 201);
			} else if ((this.form.getAmount() == null) || (this.form.getAmount().doubleValue() <= 0.0D)) {
				this.form.setJsonMsg("amount不能为空", false, json, 1001);
			} else {
				int userId = account.getUsers().getUserId().intValue();
				BalanceDrawRequest req = new BalanceDrawRequest();
				req.setRequestTime(new Date());
				req.setUserId(Integer.valueOf(userId));
				req.setRequestStatus(Integer.valueOf(0));
				req.setAmount(this.form.getAmount());
				req.setRemark(this.form.getRemark());
				this.baseService.save(req);
				this.form.setJsonMsg("申请成功，等待审核!(接口调试中...)", true, json, 200);
			}
		} catch (Exception e) {
			e.printStackTrace();
			this.form.setJsonMsg(SYS_RUN_ERROR, false, json, 1001);
		}
		return "jsonPage";
	}

	public String user_recharge() {
		Map json = new HashMap();
		try {
			YAccount account = getUserInfo();
			if (account == null) {
				this.form.setJsonMsg(NO_USER, false, json, 201);
			} else if ((this.form.getAmount() == null) || (this.form.getAmount().doubleValue() <= 0.0D)) {
				this.form.setJsonMsg("amount不能为空", false, json, 1001);
			} else {
				int userId = account.getUsers().getUserId().intValue();
				BalanceDetails req = new BalanceDetails();
				req.setTradeDate(new Date());
				req.setUserId(Integer.valueOf(userId));
				req.setIncome(this.form.getAmount());
				req.setRemark(this.form.getRemark());
				Serializable id = this.baseService.save(req);
				BalanceDetails info = (BalanceDetails) this.baseService
						.bean(" from BalanceDetails as b where b.balanceId = " + id.toString());
				json.put("info", info);
				this.form.setJsonMsg("success", true, json, 200);
			}
		} catch (Exception e) {
			e.printStackTrace();
			this.form.setJsonMsg(SYS_RUN_ERROR, false, json, 1001);
		}
		return "jsonPage";
	}
}