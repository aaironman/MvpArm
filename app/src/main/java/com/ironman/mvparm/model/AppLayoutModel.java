package com.ironman.mvparm.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by 武昌丶鱼 on 2017/3/3.
 * Description:
 */

public class AppLayoutModel {


    /**
     * wechat_show : 0,1.0.0
     * payment : [{"channel":"quick","title":"","name":"一键支付","default":1,"desc":"一分钟到账"},{"channel":"alipay",
     * "name":"支付宝","default":0,"desc":"2小时到账","url":"/html/mobile/pages/alipay.html"}]
     * payment_title : 支持多种还款方式，方便快捷
     * payment_desc : [{"title":"主动还款（银行卡）","img":"/html/mobile/static/unionpay.png",
     * "url":"/html/mobile/pages/help-list.html#!mid=13&cid=1303"},{"title":"到期自动扣款（银行卡）",
     * "img":"/html/mobile/static/unionpay.png","url":"/html/mobile/pages/help-list.html#!mid=13&cid=1304"}]
     * overdue_fee : 2
     * loan_extend_fee : 1
     * address_book : Y
     * address_book_day : 3
     * user_feed : Y
     * user_feed_day : 1
     * zmxy_success_score : 1
     * loan_money_min : 500
     * loan_money_max : 3000
     * first_loan_money_min : 500
     * first_loan_money_max : 1000
     * loan_day : 7,15,30
     * loan_day_default : 30
     * loan_step : 100
     * apr : 0.01,0.008,0.006
     * loan_repay_phone : 4001116767
     * kefu_qq : 4001116767
     * calc_rule : amount*days*apr
     * calc_rule_title : 综合费用=居间服务费+风控服务费+风险准备金
     * refresh_title : 你的手机钱包
     * check_num : 6
     * check_all : [{"id":"userface","disable":0,"title":"身份认证","url":null},{"id":"userinfo","disable":0,
     * "title":"个人信息","url":null},{"id":"userwork","disable":0,"title":"工作信息","url":null},{"id":"mobile","disable":0,
     * "title":"手机认证","url":"/user/mobile/start"},{"id":"userbank","disable":0,"title":"收款银行卡","url":null},
     * {"id":"zmxy","disable":0,"title":"芝麻信用","url":"/html/mobile/pages/zhima.html"}]
     * check_ext : [{"id":"social","disable":0,"title":"社交信息","url":"","callback":"","yes":"已认证","no":"未认证",
     * "doing":"认证中","son":[{"id":"weixin","disable":0,"title":"微信","url":"","callback":""},{"id":"qq","disable":0,
     * "title":"QQ","url":"","callback":""},{"id":"zfb","disable":0,"title":"支付宝","url":"","callback":""}]}]
     * index_title : 你可以立即申请借款了
     * outofmoney_index_title : 信用额度不足,咱不能借款
     * overdue_index_title : 您有逾期的借款，请先还钱！
     * disable_tips : 用户冻结暂不能使用
     * index_desc :
     * no_card_title : 尚未绑定收款银行卡
     * no_loan_num : 成功借款0次
     * base_color :
     * base_button : []
     * loan_button : 认证信息后即可借钱
     * loan_button_now : 马上借钱
     * loan_button_less : 可用额度不足
     * loan_button_overdue : 您有逾期，请先还钱！
     * userinfo_desc : 银行级别信息加密保存
     * loan_apply_contract : [{"title":"好钱包借款协议","url":"/html/contract/loan.html"}]
     * reg_contract : {"title":"用户注册协议","url":"/html/contract/regcontract.html"}
     * keybord_title : 好钱包 放心借
     * loan_contract : [{"title":"借款协议","url":"/html/contract/loan.html"},{"title":"平台服务协议",
     * "url":"/html/contract/service.html"},{"title":"授权扣款委托书","url":"/html/contract/authorization.html"}]
     * help_center : {"title":"帮助中心","url":"/html/mobile/pages/help.html"}
     * user_coupon : {"title":"优惠券","url":"/html/mobile/pages/coupon.html"}
     * select_coupon : {"title":"选择优惠券","url":"/html/mobile/pages/selectcoupon.html"}
     * about_us : {"title":"关于我们","url":"/html/mobile/pages/aboutus.html"}
     * about_extend : {"title":"关于展期","url":"/html/mobile/pages/help-list.html#!mid=14&cid=1403"}
     * add_vcredit : {"title":"如何提额","url":"/html/mobile/pages/tie.html"}
     * invite : {"title":"我的邀请","url":"/html/mobile/pages/invite.html"}
     * extend_contract : {"title":"展期服务协议","url":"/html/mobile/pages/coupon.html"}
     * sum_vcredit_desc : 额度提升
     * loan_xq_title : 申请展期
     * loan_xq_desc : 申请还款展期服务需要支付费用，请确认并支付
     * loan_xq_about_desc : 完成支付展期总服务费后，即可成功展期
     * face_desc : 1.拍摄身份证照片请注意区分人像面、国徽面
     2.身份证需本人，且拍摄清晰
     * mobile_desc : 1.请授权本人实名认证手机号（使用满3个月）
     2.登录成功后将受到运营商通知短信，无需回复
     * bankcard_desc : 1.请填写本人名下有效银行卡
     2.登录成功后将受到运营商通知短信，无需回复
     * repay_wx_desc : 请确保微信零钱或银行卡资金充足
     * zmxy_fail_url : /html/mobile/pages/zhimaerror.html
     * mobile_fail_url : /html/mobile/pages/vmerror.html
     * zmxy_success_url : /html/mobile/pages/zhimasuccess.html
     * mobile_success_url : /html/mobile/pages/vmsuccess.html
     * mobile_process_url : /html/mobile/pages/vmprocess.html
     * feed_step_day : 1
     * contact_step_day : 7
     * invite_title :
     * invite_desc :
     * invite_pic : /html/mobile/static/share.jpg
     * loan_xq_day : 1
     * face_check_thresholds : 1e-4
     * sendmsg_url : http://dev.yiqihao.com/
     * disable_day : 1
     * feedback : {"title":"意见反馈","url":"/html/mobile/pages/feedback.html"}
     * complaint : {"title":"催收投诉","url":"/html/mobile/pages/complain.html"}
     * start_banner : {"img":"/html/mobile/static/default0330.png","url":"/html/activity/2017/regaward/"}
     * holder : {"userinfo":{"address":"如：东湖路56号向阳花园1栋11层1101室","loan_reason":"如：临时周转"},"userwork":{"industry":"如：娱乐业","position":"如：服务员/收银/经理","month_wages":"如：1000/2000/3000","address":"如：淮海路2号2栋2层2室","phone":"(选填)如：020-80080128"}}
     */

    private String wechat_show;
    private String payment_title;
    private int overdue_fee;
    private int loan_extend_fee;
    private String address_book;
    private String address_book_day;
    private String user_feed;
    private String user_feed_day;
    private int zmxy_success_score;
    private int loan_money_min;
    private int loan_money_max;
    private int first_loan_money_min;
    private int first_loan_money_max;
    private String loan_day;
    private int loan_day_default;
    private int loan_step;
    private String apr;
    private String loan_repay_phone;
    private String kefu_qq;
    private String kefu_wechat;
    private String kefu_work;
    private String calc_rule;
    private String calc_rule_title;
    private String refresh_title;
    private int check_num;
    private String index_title;
    private String outofmoney_index_title;
    private String overdue_index_title;
    private String disable_tips;
    private String index_desc;
    private String no_card_title;
    private String no_loan_num;
    private String base_color;
    private String loan_apply_alter;
    private String loan_apply_alter_info;
    private String loan_button;
    private String loan_button_now;
    private String loan_button_less;
    private String loan_button_overdue;
    private String userinfo_desc;
    private RegContractBean reg_contract;
    private String keybord_title;
    private String alipay_wait;
    private HelpCenterBean help_center;
    private UserCouponBean user_coupon;
    private SelectCouponBean select_coupon;
    private AboutUsBean about_us;
    private AboutExtendBean about_extend;
    private AddVcreditBean add_vcredit;
    private InviteBean invite;
    private ExtendContractBean extend_contract;
    private String sum_vcredit_desc;
    private String loan_xq_title;
    private String loan_xq_desc;
    private String loan_xq_about_desc;
    private String face_desc;
    private String mobile_desc;
    private String bankcard_desc;
    private String repay_wx_desc;
    private String zmxy_fail_url;
    private String mobile_fail_url;
    private String zmxy_success_url;
    private String mobile_success_url;
    private String mobile_process_url;
    private int feed_step_day;
    private int contact_step_day;
    private String invite_title;
    private String invite_desc;
    private String invite_pic;
    private String year_apr_title;
    private int loan_xq_day;
    private String face_check_thresholds;
    private String sendmsg_url;
    private int disable_day;
    private FeedbackBean feedback;
    private ComplaintBean complaint;
    private StartBannerBean start_banner;
    private HolderBean holder;
    private List<PaymentBean> payment;
    private List<PaymentDescBean> payment_desc;
    private String year_apr;
    private List<CheckAllBean> check_all;
    private List<CheckExtBean> check_ext;
    private List<?> base_button;
    private List<LoanApplyContractBean> loan_apply_contract;
    private List<LoanContractBean> loan_contract;
    private List<ImtContractBean> imt_contract;

    private String alipay_tip;
    private String alipay_active;
    private String alipay_paste;

    private String hfq_syn_fee;
    private String hfq_loan_fee;
    private String hfq_current_repay;
    private String hfq_overdue_fine;
    private String hfq_prepayment_fine;

    private String user_address;

    public String getUser_address() {
        return user_address;
    }

    public void setUser_address(String user_address) {
        this.user_address = user_address;
    }

    public String getAlipay_tip() {
        return alipay_tip;
    }

    public String getYear_apr_title() {
        return year_apr_title;
    }

    public void setYear_apr_title(String year_apr_title) {
        this.year_apr_title = year_apr_title;
    }

    public String getAlipay_paste() {
        return alipay_paste;
    }

    public void setAlipay_paste(String alipay_paste) {
        this.alipay_paste = alipay_paste;
    }

    public String getAlipay_wait() {
        return alipay_wait;
    }

    public void setAlipay_wait(String alipay_wait) {
        this.alipay_wait = alipay_wait;
    }

    public void setAlipay_tip(String alipay_tip) {
        this.alipay_tip = alipay_tip;
    }

    public String getAlipay_active() {
        return alipay_active;
    }

    public void setAlipay_active(String alipay_active) {
        this.alipay_active = alipay_active;
    }

    public String getWechat_show() {
        return wechat_show;
    }

    public void setWechat_show(String wechat_show) {
        this.wechat_show = wechat_show;
    }

    public String getPayment_title() {
        return payment_title;
    }

    public void setPayment_title(String payment_title) {
        this.payment_title = payment_title;
    }

    public int getOverdue_fee() {
        return overdue_fee;
    }

    public void setOverdue_fee(int overdue_fee) {
        this.overdue_fee = overdue_fee;
    }

    public int getLoan_extend_fee() {
        return loan_extend_fee;
    }

    public void setLoan_extend_fee(int loan_extend_fee) {
        this.loan_extend_fee = loan_extend_fee;
    }

    public String getAddress_book() {
        return address_book;
    }

    public void setAddress_book(String address_book) {
        this.address_book = address_book;
    }

    public String getAddress_book_day() {
        return address_book_day;
    }

    public void setAddress_book_day(String address_book_day) {
        this.address_book_day = address_book_day;
    }

    public String getUser_feed() {
        return user_feed;
    }

    public void setUser_feed(String user_feed) {
        this.user_feed = user_feed;
    }

    public String getUser_feed_day() {
        return user_feed_day;
    }

    public void setUser_feed_day(String user_feed_day) {
        this.user_feed_day = user_feed_day;
    }

    public String getYear_apr() {
        return year_apr;
    }

    public void setYear_apr(String year_apr) {
        this.year_apr = year_apr;
    }

    public int getZmxy_success_score() {
        return zmxy_success_score;
    }

    public void setZmxy_success_score(int zmxy_success_score) {
        this.zmxy_success_score = zmxy_success_score;
    }

    public int getLoan_money_min() {
        return loan_money_min;
    }

    public void setLoan_money_min(int loan_money_min) {
        this.loan_money_min = loan_money_min;
    }
    
    public String getLoan_apply_alter() {
        return loan_apply_alter;
    }
    
    public void setLoan_apply_alter(String loan_apply_alter) {
        this.loan_apply_alter = loan_apply_alter;
    }
    
    public String getLoan_apply_alter_info() {
        return loan_apply_alter_info;
    }
    
    public void setLoan_apply_alter_info(String loan_apply_alter_info) {
        this.loan_apply_alter_info = loan_apply_alter_info;
    }
    
    public int getLoan_money_max() {
        return loan_money_max;
    }

    public void setLoan_money_max(int loan_money_max) {
        this.loan_money_max = loan_money_max;
    }

    public int getFirst_loan_money_min() {
        return first_loan_money_min;
    }

    public void setFirst_loan_money_min(int first_loan_money_min) {
        this.first_loan_money_min = first_loan_money_min;
    }

    public int getFirst_loan_money_max() {
        return first_loan_money_max;
    }

    public void setFirst_loan_money_max(int first_loan_money_max) {
        this.first_loan_money_max = first_loan_money_max;
    }

    public String getLoan_day() {
        return loan_day;
    }

    public void setLoan_day(String loan_day) {
        this.loan_day = loan_day;
    }

    public int getLoan_day_default() {
        return loan_day_default;
    }

    public void setLoan_day_default(int loan_day_default) {
        this.loan_day_default = loan_day_default;
    }

    public int getLoan_step() {
        return loan_step;
    }

    public void setLoan_step(int loan_step) {
        this.loan_step = loan_step;
    }

    public String getApr() {
        return apr;
    }

    public void setApr(String apr) {
        this.apr = apr;
    }

    public String getLoan_repay_phone() {
        return loan_repay_phone;
    }

    public void setLoan_repay_phone(String loan_repay_phone) {
        this.loan_repay_phone = loan_repay_phone;
    }

    public String getKefu_qq() {
        return kefu_qq;
    }

    public void setKefu_qq(String kefu_qq) {
        this.kefu_qq = kefu_qq;
    }

    public String getCalc_rule() {
        return calc_rule;
    }

    public void setCalc_rule(String calc_rule) {
        this.calc_rule = calc_rule;
    }

    public String getCalc_rule_title() {
        return calc_rule_title;
    }

    public void setCalc_rule_title(String calc_rule_title) {
        this.calc_rule_title = calc_rule_title;
    }

    public String getRefresh_title() {
        return refresh_title;
    }

    public void setRefresh_title(String refresh_title) {
        this.refresh_title = refresh_title;
    }

    public int getCheck_num() {
        return check_num;
    }

    public void setCheck_num(int check_num) {
        this.check_num = check_num;
    }

    public String getIndex_title() {
        return index_title;
    }

    public void setIndex_title(String index_title) {
        this.index_title = index_title;
    }

    public String getOutofmoney_index_title() {
        return outofmoney_index_title;
    }

    public void setOutofmoney_index_title(String outofmoney_index_title) {
        this.outofmoney_index_title = outofmoney_index_title;
    }

    public String getOverdue_index_title() {
        return overdue_index_title;
    }

    public void setOverdue_index_title(String overdue_index_title) {
        this.overdue_index_title = overdue_index_title;
    }

    public String getDisable_tips() {
        return disable_tips;
    }

    public void setDisable_tips(String disable_tips) {
        this.disable_tips = disable_tips;
    }

    public String getIndex_desc() {
        return index_desc;
    }

    public void setIndex_desc(String index_desc) {
        this.index_desc = index_desc;
    }

    public String getNo_card_title() {
        return no_card_title;
    }

    public void setNo_card_title(String no_card_title) {
        this.no_card_title = no_card_title;
    }

    public String getNo_loan_num() {
        return no_loan_num;
    }

    public void setNo_loan_num(String no_loan_num) {
        this.no_loan_num = no_loan_num;
    }

    public String getBase_color() {
        return base_color;
    }

    public void setBase_color(String base_color) {
        this.base_color = base_color;
    }

    public String getLoan_button() {
        return loan_button;
    }

    public void setLoan_button(String loan_button) {
        this.loan_button = loan_button;
    }

    public String getLoan_button_now() {
        return loan_button_now;
    }

    public void setLoan_button_now(String loan_button_now) {
        this.loan_button_now = loan_button_now;
    }

    public String getLoan_button_less() {
        return loan_button_less;
    }

    public void setLoan_button_less(String loan_button_less) {
        this.loan_button_less = loan_button_less;
    }

    public String getLoan_button_overdue() {
        return loan_button_overdue;
    }

    public void setLoan_button_overdue(String loan_button_overdue) {
        this.loan_button_overdue = loan_button_overdue;
    }

    public String getUserinfo_desc() {
        return userinfo_desc;
    }

    public void setUserinfo_desc(String userinfo_desc) {
        this.userinfo_desc = userinfo_desc;
    }

    public RegContractBean getReg_contract() {
        return reg_contract;
    }

    public void setReg_contract(RegContractBean reg_contract) {
        this.reg_contract = reg_contract;
    }

    public String getKeybord_title() {
        return keybord_title;
    }

    public void setKeybord_title(String keybord_title) {
        this.keybord_title = keybord_title;
    }

    public HelpCenterBean getHelp_center() {
        return help_center;
    }

    public void setHelp_center(HelpCenterBean help_center) {
        this.help_center = help_center;
    }

    public UserCouponBean getUser_coupon() {
        return user_coupon;
    }

    public void setUser_coupon(UserCouponBean user_coupon) {
        this.user_coupon = user_coupon;
    }

    public SelectCouponBean getSelect_coupon() {
        return select_coupon;
    }

    public void setSelect_coupon(SelectCouponBean select_coupon) {
        this.select_coupon = select_coupon;
    }

    public AboutUsBean getAbout_us() {
        return about_us;
    }

    public void setAbout_us(AboutUsBean about_us) {
        this.about_us = about_us;
    }

    public AboutExtendBean getAbout_extend() {
        return about_extend;
    }

    public void setAbout_extend(AboutExtendBean about_extend) {
        this.about_extend = about_extend;
    }

    public AddVcreditBean getAdd_vcredit() {
        return add_vcredit;
    }

    public void setAdd_vcredit(AddVcreditBean add_vcredit) {
        this.add_vcredit = add_vcredit;
    }

    public InviteBean getInvite() {
        return invite;
    }

    public void setInvite(InviteBean invite) {
        this.invite = invite;
    }

    public ExtendContractBean getExtend_contract() {
        return extend_contract;
    }

    public void setExtend_contract(ExtendContractBean extend_contract) {
        this.extend_contract = extend_contract;
    }

    public String getSum_vcredit_desc() {
        return sum_vcredit_desc;
    }

    public void setSum_vcredit_desc(String sum_vcredit_desc) {
        this.sum_vcredit_desc = sum_vcredit_desc;
    }

    public String getLoan_xq_title() {
        return loan_xq_title;
    }

    public void setLoan_xq_title(String loan_xq_title) {
        this.loan_xq_title = loan_xq_title;
    }
    
    public String getKefu_wechat() {
        return kefu_wechat;
    }
    
    public void setKefu_wechat(String kefu_wechat) {
        this.kefu_wechat = kefu_wechat;
    }
    
    public String getKefu_work() {
        return kefu_work;
    }
    
    public void setKefu_work(String kefu_work) {
        this.kefu_work = kefu_work;
    }
    
    public String getLoan_xq_desc() {
        return loan_xq_desc;
    }

    public void setLoan_xq_desc(String loan_xq_desc) {
        this.loan_xq_desc = loan_xq_desc;
    }

    public String getLoan_xq_about_desc() {
        return loan_xq_about_desc;
    }

    public void setLoan_xq_about_desc(String loan_xq_about_desc) {
        this.loan_xq_about_desc = loan_xq_about_desc;
    }

    public String getFace_desc() {
        return face_desc;
    }

    public void setFace_desc(String face_desc) {
        this.face_desc = face_desc;
    }

    public String getMobile_desc() {
        return mobile_desc;
    }

    public void setMobile_desc(String mobile_desc) {
        this.mobile_desc = mobile_desc;
    }

    public String getBankcard_desc() {
        return bankcard_desc;
    }

    public void setBankcard_desc(String bankcard_desc) {
        this.bankcard_desc = bankcard_desc;
    }

    public String getRepay_wx_desc() {
        return repay_wx_desc;
    }

    public void setRepay_wx_desc(String repay_wx_desc) {
        this.repay_wx_desc = repay_wx_desc;
    }

    public String getZmxy_fail_url() {
        return zmxy_fail_url;
    }

    public void setZmxy_fail_url(String zmxy_fail_url) {
        this.zmxy_fail_url = zmxy_fail_url;
    }

    public String getMobile_fail_url() {
        return mobile_fail_url;
    }

    public void setMobile_fail_url(String mobile_fail_url) {
        this.mobile_fail_url = mobile_fail_url;
    }

    public String getZmxy_success_url() {
        return zmxy_success_url;
    }

    public void setZmxy_success_url(String zmxy_success_url) {
        this.zmxy_success_url = zmxy_success_url;
    }

    public String getMobile_success_url() {
        return mobile_success_url;
    }

    public void setMobile_success_url(String mobile_success_url) {
        this.mobile_success_url = mobile_success_url;
    }

    public String getMobile_process_url() {
        return mobile_process_url;
    }

    public void setMobile_process_url(String mobile_process_url) {
        this.mobile_process_url = mobile_process_url;
    }

    public int getFeed_step_day() {
        return feed_step_day;
    }

    public void setFeed_step_day(int feed_step_day) {
        this.feed_step_day = feed_step_day;
    }

    public int getContact_step_day() {
        return contact_step_day;
    }

    public void setContact_step_day(int contact_step_day) {
        this.contact_step_day = contact_step_day;
    }

    public String getInvite_title() {
        return invite_title;
    }

    public void setInvite_title(String invite_title) {
        this.invite_title = invite_title;
    }

    public String getInvite_desc() {
        return invite_desc;
    }

    public void setInvite_desc(String invite_desc) {
        this.invite_desc = invite_desc;
    }

    public String getInvite_pic() {
        return invite_pic;
    }

    public void setInvite_pic(String invite_pic) {
        this.invite_pic = invite_pic;
    }

    public int getLoan_xq_day() {
        return loan_xq_day;
    }

    public void setLoan_xq_day(int loan_xq_day) {
        this.loan_xq_day = loan_xq_day;
    }

    public String getFace_check_thresholds() {
        return face_check_thresholds;
    }

    public void setFace_check_thresholds(String face_check_thresholds) {
        this.face_check_thresholds = face_check_thresholds;
    }

    public String getSendmsg_url() {
        return sendmsg_url;
    }

    public void setSendmsg_url(String sendmsg_url) {
        this.sendmsg_url = sendmsg_url;
    }

    public int getDisable_day() {
        return disable_day;
    }

    public void setDisable_day(int disable_day) {
        this.disable_day = disable_day;
    }

    public FeedbackBean getFeedback() {
        return feedback;
    }

    public void setFeedback(FeedbackBean feedback) {
        this.feedback = feedback;
    }

    public ComplaintBean getComplaint() {
        return complaint;
    }

    public void setComplaint(ComplaintBean complaint) {
        this.complaint = complaint;
    }

    public StartBannerBean getStart_banner() {
        return start_banner;
    }

    public void setStart_banner(StartBannerBean start_banner) {
        this.start_banner = start_banner;
    }

    public HolderBean getHolder() {
        return holder;
    }

    public void setHolder(HolderBean holder) {
        this.holder = holder;
    }

    public List<PaymentBean> getPayment() {
        return payment;
    }

    public void setPayment(List<PaymentBean> payment) {
        this.payment = payment;
    }

    public List<PaymentDescBean> getPayment_desc() {
        return payment_desc;
    }

    public void setPayment_desc(List<PaymentDescBean> payment_desc) {
        this.payment_desc = payment_desc;
    }

    public List<CheckAllBean> getCheck_all() {
        return check_all;
    }

    public void setCheck_all(List<CheckAllBean> check_all) {
        this.check_all = check_all;
    }

    public List<CheckExtBean> getCheck_ext() {
        return check_ext;
    }

    public void setCheck_ext(List<CheckExtBean> check_ext) {
        this.check_ext = check_ext;
    }

    public List<?> getBase_button() {
        return base_button;
    }

    public void setBase_button(List<?> base_button) {
        this.base_button = base_button;
    }

    public List<LoanApplyContractBean> getLoan_apply_contract() {
        return loan_apply_contract;
    }

    public void setLoan_apply_contract(List<LoanApplyContractBean> loan_apply_contract) {
        this.loan_apply_contract = loan_apply_contract;
    }

    public List<LoanContractBean> getLoan_contract() {
        return loan_contract;
    }

    public void setLoan_contract(List<LoanContractBean> loan_contract) {
        this.loan_contract = loan_contract;
    }

    public List<ImtContractBean> getImt_contract() {
        return imt_contract;
    }

    public void setImt_contract(List<ImtContractBean> imt_contract) {
        this.imt_contract = imt_contract;
    }

    public String getHfq_syn_fee() {
        return hfq_syn_fee;
    }

    public void setHfq_syn_fee(String hfq_syn_fee) {
        this.hfq_syn_fee = hfq_syn_fee;
    }

    public String getHfq_loan_fee() {
        return hfq_loan_fee;
    }

    public void setHfq_loan_fee(String hfq_loan_fee) {
        this.hfq_loan_fee = hfq_loan_fee;
    }

    public String getHfq_current_repay() {
        return hfq_current_repay;
    }

    public void setHfq_current_repay(String hfq_current_repay) {
        this.hfq_current_repay = hfq_current_repay;
    }

    public String getHfq_overdue_fine() {
        return hfq_overdue_fine;
    }

    public void setHfq_overdue_fine(String hfq_overdue_fine) {
        this.hfq_overdue_fine = hfq_overdue_fine;
    }

    public String getHfq_prepayment_fine() {
        return hfq_prepayment_fine;
    }

    public void setHfq_prepayment_fine(String hfq_prepayment_fine) {
        this.hfq_prepayment_fine = hfq_prepayment_fine;
    }

    public static class RegContractBean {
        /**
         * title : 用户注册协议
         * url : /html/contract/regcontract.html
         */

        private String title;
        private String url;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }

    public static class HelpCenterBean {
        /**
         * title : 帮助中心
         * url : /html/mobile/pages/help.html
         */

        private String title;
        private String url;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }

    public static class UserCouponBean {
        /**
         * title : 优惠券
         * url : /html/mobile/pages/coupon.html
         */

        private String title;
        private String url;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }

    public static class SelectCouponBean {
        /**
         * title : 选择优惠券
         * url : /html/mobile/pages/selectcoupon.html
         */

        private String title;
        private String url;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }

    public static class AboutUsBean {
        /**
         * title : 关于我们
         * url : /html/mobile/pages/aboutus.html
         */

        private String title;
        private String url;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }

    public static class AboutExtendBean {
        /**
         * title : 关于展期
         * url : /html/mobile/pages/help-list.html#!mid=14&cid=1403
         */

        private String title;
        private String url;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }

    public static class AddVcreditBean {
        /**
         * title : 如何提额
         * url : /html/mobile/pages/tie.html
         */

        private String title;
        private String url;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }

    public static class InviteBean {
        /**
         * title : 我的邀请
         * url : /html/mobile/pages/invite.html
         */

        private String title;
        private String url;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }

    public static class ExtendContractBean {
        /**
         * title : 展期服务协议
         * url : /html/mobile/pages/coupon.html
         */

        private String title;
        private String url;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }

    public static class FeedbackBean {
        /**
         * title : 意见反馈
         * url : /html/mobile/pages/feedback.html
         */

        private String title;
        private String url;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }

    public static class ComplaintBean {
        /**
         * title : 催收投诉
         * url : /html/mobile/pages/complain.html
         */

        private String title;
        private String url;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }

    public static class StartBannerBean {
        /**
         * img : /html/mobile/static/default0330.png
         * url : /html/activity/2017/regaward/
         */

        private String img;
        private String url;

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }

    public static class HolderBean {
        /**
         * userinfo : {"address":"如：东湖路56号向阳花园1栋11层1101室","loan_reason":"如：临时周转"}
         * userwork : {"industry":"如：娱乐业","position":"如：服务员/收银/经理","month_wages":"如：1000/2000/3000",
         * "address":"如：淮海路2号2栋2层2室","phone":"(选填)如：020-80080128"}
         */

        private UserinfoBean userinfo;
        private UserworkBean userwork;

        public UserinfoBean getUserinfo() {
            return userinfo;
        }

        public void setUserinfo(UserinfoBean userinfo) {
            this.userinfo = userinfo;
        }

        public UserworkBean getUserwork() {
            return userwork;
        }

        public void setUserwork(UserworkBean userwork) {
            this.userwork = userwork;
        }

        public static class UserinfoBean {
            /**
             * address : 如：东湖路56号向阳花园1栋11层1101室
             * loan_reason : 如：临时周转
             */

            private String address;
            private String loan_reason;

            public String getAddress() {
                return address;
            }

            public void setAddress(String address) {
                this.address = address;
            }

            public String getLoan_reason() {
                return loan_reason;
            }

            public void setLoan_reason(String loan_reason) {
                this.loan_reason = loan_reason;
            }
        }

        public static class UserworkBean {
            /**
             * industry : 如：娱乐业
             * position : 如：服务员/收银/经理
             * month_wages : 如：1000/2000/3000
             * address : 如：淮海路2号2栋2层2室
             * phone : (选填)如：020-80080128
             */

            private String industry;
            private String position;
            private String month_wages;
            private String address;
            private String phone;

            public String getIndustry() {
                return industry;
            }

            public void setIndustry(String industry) {
                this.industry = industry;
            }

            public String getPosition() {
                return position;
            }

            public void setPosition(String position) {
                this.position = position;
            }

            public String getMonth_wages() {
                return month_wages;
            }

            public void setMonth_wages(String month_wages) {
                this.month_wages = month_wages;
            }

            public String getAddress() {
                return address;
            }

            public void setAddress(String address) {
                this.address = address;
            }

            public String getPhone() {
                return phone;
            }

            public void setPhone(String phone) {
                this.phone = phone;
            }
        }
    }

    public static class PaymentBean implements Parcelable {
        /**
         * channel : quick
         * title :
         * name : 一键支付
         * default : 1
         * desc : 一分钟到账
         * url : /html/mobile/pages/alipay.html
         */


        private String channel;
        private String title;
        private String name;
        @SerializedName("default")
        private int defaultX;
        private String desc;
        private String url;

        public String getChannel() {
            return channel;
        }

        public void setChannel(String channel) {
            this.channel = channel;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getDefaultX() {
            return defaultX;
        }

        public void setDefaultX(int defaultX) {
            this.defaultX = defaultX;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.channel);
            dest.writeString(this.title);
            dest.writeString(this.name);
            dest.writeInt(this.defaultX);
            dest.writeString(this.desc);
            dest.writeString(this.url);
        }

        public PaymentBean() {
        }

        protected PaymentBean(Parcel in) {
            this.channel = in.readString();
            this.title = in.readString();
            this.name = in.readString();
            this.defaultX = in.readInt();
            this.desc = in.readString();
            this.url = in.readString();
        }

        public static final Creator<PaymentBean> CREATOR = new Creator<PaymentBean>() {
            @Override
            public PaymentBean createFromParcel(Parcel source) {
                return new PaymentBean(source);
            }

            @Override
            public PaymentBean[] newArray(int size) {
                return new PaymentBean[size];
            }
        };
    }

    public static class PaymentDescBean {
        /**
         * title : 主动还款（银行卡）
         * img : /html/mobile/static/unionpay.png
         * url : /html/mobile/pages/help-list.html#!mid=13&cid=1303
         */

        private String title;
        private String img;
        private String url;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }

    public static class CheckAllBean {
        /**
         * id : userface
         * disable : 0
         * title : 身份认证
         * url : null
         */

        private String id;
        private int disable;
        private String title;
        private Object url;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public int getDisable() {
            return disable;
        }

        public void setDisable(int disable) {
            this.disable = disable;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public Object getUrl() {
            return url;
        }

        public void setUrl(Object url) {
            this.url = url;
        }
    }

    public static class CheckExtBean {
        /**
         * id : social
         * disable : 0
         * title : 社交信息
         * url :
         * callback :
         * yes : 已认证
         * no : 未认证
         * doing : 认证中
         * son : [{"id":"weixin","disable":0,"title":"微信","url":"","callback":""},{"id":"qq","disable":0,"title":"QQ","url":"","callback":""},{"id":"zfb","disable":0,"title":"支付宝","url":"","callback":""}]
         */

        private String id;
        private int disable;
        private String title;
        private String url;
        private String callback;
        private String yes;
        private String no;
        private String doing;
        private List<SonBean> son;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public int getDisable() {
            return disable;
        }

        public void setDisable(int disable) {
            this.disable = disable;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getCallback() {
            return callback;
        }

        public void setCallback(String callback) {
            this.callback = callback;
        }

        public String getYes() {
            return yes;
        }

        public void setYes(String yes) {
            this.yes = yes;
        }

        public String getNo() {
            return no;
        }

        public void setNo(String no) {
            this.no = no;
        }

        public String getDoing() {
            return doing;
        }

        public void setDoing(String doing) {
            this.doing = doing;
        }

        public List<SonBean> getSon() {
            return son;
        }

        public void setSon(List<SonBean> son) {
            this.son = son;
        }

        public static class SonBean {
            /**
             * id : weixin
             * disable : 0
             * title : 微信
             * url :
             * callback :
             */

            private String id;
            private int disable;
            private String title;
            private String url;
            private String callback;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public int getDisable() {
                return disable;
            }

            public void setDisable(int disable) {
                this.disable = disable;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getCallback() {
                return callback;
            }

            public void setCallback(String callback) {
                this.callback = callback;
            }
        }
    }

    public static class LoanApplyContractBean {
        /**
         * title : 好钱包借款协议
         * url : /html/contract/loan.html
         */

        private String title;
        private String url;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }

    public static class LoanContractBean {
        /**
         * title : 借款协议
         * url : /html/contract/loan.html
         */

        private String title;
        private String url;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }

    public static class ImtContractBean {
        /**
         * title : 好分期借款协议
         * url : /html/contract/loan.html
         */

        private String title;
        private String url;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
