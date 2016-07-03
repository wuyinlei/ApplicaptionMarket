package yinlei.applicaptionmarket.ui.activity;


import android.support.design.widget.TextInputLayout;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import butterknife.Bind;
import butterknife.OnClick;
import yinlei.applicaptionmarket.R;
import yinlei.applicaptionmarket.contants.Constants;
import yinlei.applicaptionmarket.pojo.UserInfo;
import yinlei.applicaptionmarket.ui.base.BaseAppCompatActivity;
import yinlei.applicaptionmarket.utils.RxBinderUtils;
import yinlei.applicaptionmarket.utils.UIUtils;
import yinlei.applicaptionmarket.viewModels.UserViewModel;

public class LoginActivity extends BaseAppCompatActivity {


    private UserViewModel viewModel;
    private  RxBinderUtils rxBinderUtil = new RxBinderUtils(this);

    @Bind(R.id.toolbar)
    Toolbar mToolbar;
    @Bind(R.id.editTextName)
    EditText mEtTextName;
    @Bind(R.id.textInputLayoutName)
    TextInputLayout mTextInputName;
    @Bind(R.id.editTextPassword)
    EditText mEditTextPassword;
    @Bind(R.id.textInputLayoutPassword)
    TextInputLayout mTextInputLayoutPassword;
    @Bind(R.id.buttonLogin)
    Button mButtonLogin;

    @Override
    protected void initUiAndListener() {
        initToolBar(mToolbar);
        //checkName(mEtTextName.getText().toString(), true);

        mTextInputName.setErrorEnabled(true);
        mTextInputLayoutPassword.setErrorEnabled(true);
        viewModel = new UserViewModel();
       /* setSupportActionBar(mToolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(R.string.user_login);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);*/
    }

    @OnClick(R.id.buttonLogin)
    public void onClick(View view) {
        if (view.getId() == R.id.buttonLogin) {

            UIUtils.hideKeyBoard(this);

            if (checkPwd(mEditTextPassword.getText().toString(), true) &&
                    checkName(mEtTextName.getText().toString(), true)) {

                resetModel();

                viewModel.setUserInfo(mEtTextName.getText().toString(),mEditTextPassword.getText().toString())
                        .subscribeToDataStore();

                Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();
                finish();
            } else {
                Toast.makeText(this, "请检查登录信息", Toast.LENGTH_SHORT).show();
            }


        }
    }

    private void resetModel() {

        viewModel.unsubscribeFromDataStore();
        viewModel.dispose();
        viewModel = null;
        viewModel = new UserViewModel();
        setViewModel(viewModel);
    }

    private void setViewModel(UserViewModel viewModel) {

        rxBinderUtil.clear();
        if (viewModel != null) {
            rxBinderUtil.bindProperty(viewModel.getRepository(), this::setRepository);
        }
    }

    private void setRepository(UserInfo userInfo) {

        if (userInfo != null && userInfo.getData() != null) {
            Toast.makeText(this, "登录成功：" +
                    userInfo.getData().getUsername(), Toast.LENGTH_SHORT).show();
        }
    }

    private boolean checkName(CharSequence name, boolean isLogin) {
        if (TextUtils.isEmpty(name)) {
            if (isLogin) {
                mTextInputName.setError(getString(R.string.error_login_empty));
                return false;
            }
        } else {

            /**
             * String rule = "^1(3|5|7|8|4)\\d{9}";
             Pattern p = Pattern.compile(rule);
             Matcher m = p.matcher(phone);

             if (!m.matches()) {
             ToastUtils.show(this,"您输入的手机号码格式不正确");
             return;
             }
             */
           /* String rulePhone = Constants.REG_PHONE_CHINA;
            String ruleEmail = Constants.REG_EMAIL;
            Pattern pPhone = Pattern.compile(rulePhone);
            Pattern pEmail = Pattern.compile(ruleEmail);
            Matcher mPhone = pPhone.matcher(rulePhone);
            Matcher mEmail = pEmail.matcher(ruleEmail);*/

            mTextInputName.setError(null);
        }
        return true;

    }

    private boolean checkPwd(CharSequence pwd, boolean isLogin) {
        if (TextUtils.isEmpty(pwd)) {
            if (isLogin) {
                mTextInputLayoutPassword.setError(getString(R.string.error_pswd_empty));
                return false;
            }

        } else {
            mTextInputLayoutPassword.setError(null);
        }
        return true;
    }

    @Override
    protected boolean isApplyStatusBarTranslucency() {
        return true;
    }

    @Override
    public int initContentView() {
        return R.layout.activity_login;
    }


}
