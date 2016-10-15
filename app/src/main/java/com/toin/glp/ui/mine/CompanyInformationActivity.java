package com.toin.glp.ui.mine;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.toin.glp.App;
import com.toin.glp.Navigation;
import com.toin.glp.R;
import com.toin.glp.StringUtils;
import com.toin.glp.api.ApiFactory;
import com.toin.glp.api.ApiName;
import com.toin.glp.base.BaseActivity;
import com.toin.glp.base.utils.RxBus.RxBus;
import com.toin.glp.contract.mine.CompanyInformationContract;
import com.toin.glp.event.CompanyInfoEvent;
import com.toin.glp.interactor.mine.CompanyInformationInteractor;
import com.toin.glp.models.CompanyInfoModel;
import com.toin.glp.presenter.mine.CompanyInformationPresenter;

import java.util.Map;

import butterknife.Bind;

/**
 * 企业资料 Created by hb on 16/9/5.
 */
public class CompanyInformationActivity extends
        BaseActivity<CompanyInformationPresenter, CompanyInformationInteractor> implements
        View.OnClickListener, CompanyInformationContract.View {
    private static final int REQUEST_CODE_PAGE_NAME          = 100;
    private static final int REQUEST_CODE_PAGE_ORGANIZE_CODE = 101;
    private static final int REQUEST_CODE_PAGE_TAX_NUMBER    = 102;
    private static final int REQUEST_CODE_PAGE_ADDRESS       = 103;
    private static final int REQUEST_CODE_PAGE_CORPORATE     = 104;
    private static final int REQUEST_CODE_PAGE_MODEL         = 105;
    private static final int REQUEST_CODE_PAGE_INDUSTRY      = 106;
    private static final int REQUEST_CODE_PAGE_CONTACT       = 107;
    @Bind(R.id.tv_name)
    TextView                 nameTv;
    @Bind(R.id.tv_organize_code)
    TextView                 organizeCodeTv;
    @Bind(R.id.tv_tax_number)
    TextView                 taxNumberTv;
    @Bind(R.id.tv_address)
    TextView                 addressTv;
    @Bind(R.id.tv_corporate)
    TextView                 corporateTv;
    @Bind(R.id.tv_model)
    TextView                 modelTv;
    @Bind(R.id.tv_industry)
    TextView                 industryTv;
    @Bind(R.id.tv_contact)
    TextView                 contactTv;
    private ApiFactory       factory;
    private String           content;
    private int              code;

    @Override
    protected int initLayout() {
        return R.layout.activity_company_information;
    }

    @Override
    protected void initView() {
        setOnClick(R.id.btn_back, R.id.rl_name, R.id.rl_organize_code, R.id.rl_tax_number,
                R.id.rl_address, R.id.rl_corporate, R.id.rl_model, R.id.rl_industry,
                R.id.rl_contact);
    }

    @Override
    protected void initData() {
        setActionTitle(StringUtils.TITLE_COMPANY_INFO);
        factory = new ApiFactory();
        Map<String, Object> params = ApiFactory.get_base_map();
        params.put("service", ApiName.QUERY_ENTERPRISE);
        params.put("partner_id", "188888888");
        params.put("token", App.token);
        mPresenter.getUserInfo(params);
    }

    //渲染数据
    public void setInfo(String result) {
        JSONObject obj = JSON.parseObject(result);
        CompanyInfoModel companyInfoModel = new CompanyInfoModel();
        companyInfoModel.parse(obj);
        nameTv.setText(companyInfoModel.companyMemberInfo.companyName);
        organizeCodeTv.setText(companyInfoModel.companyMemberInfo.organizationNo);
        taxNumberTv.setText(companyInfoModel.companyMemberInfo.taxNo);
        addressTv.setText(companyInfoModel.companyMemberInfo.address);
        corporateTv.setText(companyInfoModel.companyMemberInfo.legalPerson);
        modelTv.setText(companyInfoModel.companyMemberInfo.scale);
        industryTv.setText(companyInfoModel.companyMemberInfo.businessScope);
        contactTv.setText(companyInfoModel.companyMemberInfo.telephone);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_back://后退
                finish();
                break;
            case R.id.rl_name:
                String name = nameTv.getText().toString().trim();
                Navigation.goEditPage(this, name, REQUEST_CODE_PAGE_NAME,
                        EditActivity.PAGE_TYPE_NAME);
                break;
            case R.id.rl_organize_code:
                String organize_code = organizeCodeTv.getText().toString().trim();
                Navigation.goEditPage(this, organize_code, REQUEST_CODE_PAGE_ORGANIZE_CODE,
                        EditActivity.PAGE_TYPE_ORGANIZE_CODE);
                break;
            case R.id.rl_tax_number:
                String tax_number = taxNumberTv.getText().toString().trim();
                Navigation.goEditPage(this, tax_number, REQUEST_CODE_PAGE_TAX_NUMBER,
                        EditActivity.PAGE_TYPE_TAX_NUMBER);
                break;
            case R.id.rl_corporate:
                String corporate = corporateTv.getText().toString().trim();
                Navigation.goEditPage(this, corporate, REQUEST_CODE_PAGE_CORPORATE,
                        EditActivity.PAGE_TYPE_CORPORATE);
                break;
            case R.id.rl_address:
                String address = addressTv.getText().toString().trim();
                Navigation.goEditPage(this, address, REQUEST_CODE_PAGE_ADDRESS,
                        EditActivity.PAGE_TYPE_ADDRESS);
                break;
            case R.id.rl_model:
                String model = modelTv.getText().toString().trim();
                Navigation.goEditPage(this, model, REQUEST_CODE_PAGE_MODEL,
                        EditActivity.PAGE_TYPE_MODEL);
                break;
            case R.id.rl_industry:
                String industry = industryTv.getText().toString().trim();
                Navigation.goEditPage(this, industry, REQUEST_CODE_PAGE_INDUSTRY,
                        EditActivity.PAGE_TYPE_INDUSTRY);
                break;
            case R.id.rl_contact:
                String contact = contactTv.getText().toString().trim();
                Navigation.goEditPage(this, contact, REQUEST_CODE_PAGE_CONTACT,
                        EditActivity.PAGE_TYPE_CONTACT);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_PAGE_NAME && resultCode == RESULT_OK) {
            String name = data.getStringExtra(EditActivity.EXTRA_CONTENT);
            modifyCompanyInfo(name, REQUEST_CODE_PAGE_NAME);
            RxBus.getDefault().post(new CompanyInfoEvent(name));
        } else if (requestCode == REQUEST_CODE_PAGE_ORGANIZE_CODE && resultCode == RESULT_OK) {
            String name = data.getStringExtra(EditActivity.EXTRA_CONTENT);
            modifyCompanyInfo(name, REQUEST_CODE_PAGE_ORGANIZE_CODE);
        } else if (requestCode == REQUEST_CODE_PAGE_TAX_NUMBER && resultCode == RESULT_OK) {
            String name = data.getStringExtra(EditActivity.EXTRA_CONTENT);
            modifyCompanyInfo(name, REQUEST_CODE_PAGE_TAX_NUMBER);
        } else if (requestCode == REQUEST_CODE_PAGE_CORPORATE && resultCode == RESULT_OK) {
            String name = data.getStringExtra(EditActivity.EXTRA_CONTENT);
            modifyCompanyInfo(name, REQUEST_CODE_PAGE_CORPORATE);
        } else if (requestCode == REQUEST_CODE_PAGE_ADDRESS && resultCode == RESULT_OK) {
            String name = data.getStringExtra(EditActivity.EXTRA_CONTENT);
            modifyCompanyInfo(name, REQUEST_CODE_PAGE_ADDRESS);
        } else if (requestCode == REQUEST_CODE_PAGE_MODEL && resultCode == RESULT_OK) {
            String name = data.getStringExtra(EditActivity.EXTRA_CONTENT);
            modifyCompanyInfo(name, REQUEST_CODE_PAGE_MODEL);
        } else if (requestCode == REQUEST_CODE_PAGE_INDUSTRY && resultCode == RESULT_OK) {
            String name = data.getStringExtra(EditActivity.EXTRA_CONTENT);
            modifyCompanyInfo(name, REQUEST_CODE_PAGE_INDUSTRY);
        } else if (requestCode == REQUEST_CODE_PAGE_CONTACT && resultCode == RESULT_OK) {
            String name = data.getStringExtra(EditActivity.EXTRA_CONTENT);
            modifyCompanyInfo(name, REQUEST_CODE_PAGE_CONTACT);
        }
    }

    public void modifyCompanyInfo(String content, int typeCode) {
        this.content = content;
        code = typeCode;
        Map<String, Object> params = ApiFactory.get_base_map();
        params.put("service", ApiName.UPDATE_ENTERPRISE_USER_DATA);
        params.put("partner_id", "188888888");
        params.put("token", App.token);
        if (typeCode == REQUEST_CODE_PAGE_NAME) {//名字
            params.put("companyName", content);
        } else if (typeCode == REQUEST_CODE_PAGE_ORGANIZE_CODE) {//组织机构代码
            params.put("organizationNo", content);
        } else if (typeCode == REQUEST_CODE_PAGE_TAX_NUMBER) {//税务号
            params.put("taxNo", content);
        } else if (typeCode == REQUEST_CODE_PAGE_ADDRESS) {//地址
            params.put("address", content);
        } else if (typeCode == REQUEST_CODE_PAGE_CORPORATE) {//法人
            params.put("legalPerson", content);
        } else if (typeCode == REQUEST_CODE_PAGE_MODEL) {//规模
            params.put("scale", content);
        } else if (typeCode == REQUEST_CODE_PAGE_INDUSTRY) {//行业
            params.put("businessScope", content);
        } else if (typeCode == REQUEST_CODE_PAGE_CONTACT) {//联系方式
            params.put("telephone", content);
        }
        mPresenter.modifyUserInfo(params);
    }

    /**
     * 设置信息
     */
    @Override
    public void setCompanyInfo() {
        switch (code) {
            case REQUEST_CODE_PAGE_NAME://名字
                nameTv.setText(content);
                break;
            case REQUEST_CODE_PAGE_ORGANIZE_CODE://组织机构代码
                organizeCodeTv.setText(content);
                break;
            case REQUEST_CODE_PAGE_TAX_NUMBER: //税务号
                taxNumberTv.setText(content);
                break;
            case REQUEST_CODE_PAGE_ADDRESS://地址
                addressTv.setText(content);
                break;
            case REQUEST_CODE_PAGE_CORPORATE://法人
                corporateTv.setText(content);
                break;
            case REQUEST_CODE_PAGE_MODEL://规模
                modelTv.setText(content);
                break;
            case REQUEST_CODE_PAGE_INDUSTRY://行业
                industryTv.setText(content);
                break;
            case REQUEST_CODE_PAGE_CONTACT://联系方式
                contactTv.setText(content);
                break;
        }
    }
}
