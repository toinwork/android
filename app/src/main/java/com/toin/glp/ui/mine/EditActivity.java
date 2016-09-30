package com.toin.glp.ui.mine;

import android.content.Intent;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Selection;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import com.toin.glp.R;
import com.toin.glp.base.BaseActivity;
import com.toin.glp.base.utils.IMEUtils;
import com.toin.glp.base.utils.T;

import butterknife.Bind;

public class EditActivity extends BaseActivity implements View.OnClickListener {

    public static final String EXTRA_CONTENT           = "content";
    public static final String EXTRA_PAGE_TYPE         = "pageType";

    public static final String PAGE_TYPE_NAME          = "name";
    public static final String PAGE_TYPE_ORGANIZE_CODE = "organize_code";
    public static final String PAGE_TYPE_TAX_NUMBER    = "tax_number";
    public static final String PAGE_TYPE_CORPORATE     = "corporate";
    public static final String PAGE_TYPE_ADDRESS       = "address";
    public static final String PAGE_TYPE_MODEL         = "model";
    public static final String PAGE_TYPE_INDUSTRY      = "industry";
    public static final String PAGE_TYPE_CONTACT       = "contact";
    @Bind(R.id.tv_commit)
    TextView                   submitTv;
    @Bind(R.id.et_content)
    EditText                   contentEt;
    private String             pageType;
    private CheckState         checkState;
    private boolean            needEmpty;
    private String             defaultContent;

    @Override
    protected int initLayout() {
        return R.layout.activity_edit;
    }

    @Override
    protected void initView() {
        setOnClick(R.id.btn_back, R.id.tv_commit);
        submitTv.setText("保存");
    }

    @Override
    protected void initData() {
        pageType = getIntent().getStringExtra(EXTRA_PAGE_TYPE);
        if (!TextUtils.isEmpty(pageType)) {
            String title = "标题";
            String hint = title;
            int editType = EditorInfo.TYPE_CLASS_TEXT;
            if (PAGE_TYPE_NAME.equals(pageType)) {
                title = "名称";
                hint = title;
                editType = EditorInfo.TYPE_CLASS_TEXT;
                contentEt.setFilters(new InputFilter[] { new InputFilter.LengthFilter(15) });
                checkState = new CheckState() {

                    @Override
                    public boolean check(String str) {
                        if (TextUtils.isEmpty(str)) {
                            T.showShort("企业名称不能为空！");
                            return false;
                        }
                        if (!str.matches("^[a-zA-Z0-9\u4e00-\u9fa5]+$")) {
                            T.showShort("企业名称必须由数字、字母或者中文组成");
                            return false;
                        }
                        return true;
                    }
                };
            } else if (PAGE_TYPE_ORGANIZE_CODE.equals(pageType)) {
                title = "组织机构代码";
                hint = title;
                editType = EditorInfo.TYPE_CLASS_TEXT;
                contentEt.setFilters(new InputFilter[] { new InputFilter.LengthFilter(20) });
                checkState = new CheckState() {

                    @Override
                    public boolean check(String content) {
                        if (TextUtils.isEmpty(content)) {
                            T.showShort("组织机构代码不能为空！");
                            return false;
                        }
                        if (!content.matches("^[a-zA-Z0-9\u4e00-\u9fa5]+$")) {
                            T.showShort("组织机构代码必须由数字、字母或者中文组成");
                            return false;
                        }
                        return true;
                    }
                };
            } else if (PAGE_TYPE_TAX_NUMBER.equals(pageType)) {
                title = "税务号";
                hint = title;
                editType = EditorInfo.TYPE_CLASS_TEXT;
                contentEt.setFilters(new InputFilter[] { new InputFilter.LengthFilter(20) });
                checkState = new CheckState() {

                    @Override
                    public boolean check(String content) {
                        if (TextUtils.isEmpty(content)) {
                            T.showShort("税务号不能为空！");
                            return false;
                        }
                        if (!content.matches("^[a-zA-Z0-9\u4e00-\u9fa5]+$")) {
                            T.showShort("税务号必须由数字、字母或者中文组成");
                            return false;
                        }
                        return true;
                    }
                };
            } else if (PAGE_TYPE_ADDRESS.equals(pageType)) {
                title = "地址";
                hint = title;
                editType = EditorInfo.TYPE_CLASS_TEXT;
                contentEt.setFilters(new InputFilter[] { new InputFilter.LengthFilter(30) });
                checkState = new CheckState() {

                    @Override
                    public boolean check(String content) {
                        if (TextUtils.isEmpty(content)) {
                            T.showShort("地址不能为空！");
                            return false;
                        }
                        return true;
                    }
                };
            } else if (PAGE_TYPE_CORPORATE.equals(pageType)) {
                title = "法人";
                hint = title;
                editType = EditorInfo.TYPE_CLASS_TEXT;
                contentEt.setFilters(new InputFilter[] { new InputFilter.LengthFilter(20) });
                checkState = new CheckState() {

                    @Override
                    public boolean check(String content) {
                        if (TextUtils.isEmpty(content)) {
                            T.showShort("法人不能为空！");
                            return false;
                        }
                        return true;
                    }
                };
            } else if (PAGE_TYPE_MODEL.equals(pageType)) {
                title = "规模";
                hint = title;
                editType = EditorInfo.TYPE_CLASS_TEXT;
                contentEt.setFilters(new InputFilter[] { new InputFilter.LengthFilter(20) });
                checkState = new CheckState() {

                    @Override
                    public boolean check(String content) {
                        if (TextUtils.isEmpty(content)) {
                            T.showShort("规模不能为空！");
                            return false;
                        }
                        //                        if (!content.matches("^[0-9]+$")) {
                        //                            T.showShort("规模必须由数字组成");
                        //                            return false;
                        //                        }
                        return true;
                    }
                };
            } else if (PAGE_TYPE_INDUSTRY.equals(pageType)) {
                title = "行业";
                hint = title;
                editType = EditorInfo.TYPE_CLASS_TEXT;
                contentEt.setFilters(new InputFilter[] { new InputFilter.LengthFilter(20) });
                checkState = new CheckState() {

                    @Override
                    public boolean check(String content) {
                        if (TextUtils.isEmpty(content)) {
                            T.showShort("行业不能为空！");
                            return false;
                        }
                        return true;
                    }
                };
            } else if (PAGE_TYPE_CONTACT.equals(pageType)) {
                title = "联系方式";
                hint = title;
                editType = EditorInfo.TYPE_CLASS_TEXT;
                contentEt.setFilters(new InputFilter[] { new InputFilter.LengthFilter(20) });
                checkState = new CheckState() {

                    @Override
                    public boolean check(String content) {
                        if (TextUtils.isEmpty(content)) {
                            T.showShort("联系方式不能为空！");
                            return false;
                        }
                        return true;
                    }
                };
            }
            setActionTitle(title);
            contentEt.setHint(hint);
            contentEt.setInputType(editType);
        }
        defaultContent = getIntent().getStringExtra(EXTRA_CONTENT);
        if (!TextUtils.isEmpty(defaultContent)) {
            contentEt.setText(defaultContent);
            Editable etable = contentEt.getText();
            Selection.setSelection(etable, etable.length());//光标位置
        }
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_back:
                //返回
                IMEUtils.hideIME(this);
                finish();
                break;
            case R.id.tv_commit:
                //完成
                String content = contentEt.getText().toString().trim();
                if (!needEmpty && TextUtils.isEmpty(content)) {
                    T.showShort("不能为空！");
                    return;
                }
                if (content.equals(defaultContent)) {
                    T.showShort("修改内容不能和原来相同");
                    return;
                }
                if (checkState != null && !checkState.check(content)) {
                    return;
                }
                Intent data = new Intent();
                data.putExtra(EXTRA_CONTENT, content);
                setResult(RESULT_OK, data);
                IMEUtils.hideIME(this);
                finish();
                break;
            default:
                break;
        }
    }

    interface CheckState {
        abstract boolean check(String content);
    }

}
