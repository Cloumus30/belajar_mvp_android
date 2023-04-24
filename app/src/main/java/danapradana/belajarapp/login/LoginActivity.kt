package danapradana.belajarapp.login

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import danapradana.belajarapp.R
import danapradana.belajarapp.ToastGlobal
import danapradana.belajarapp.counter.view.MainActivity
import danapradana.belajarapp.register.RegisterActivity

class LoginActivity : AppCompatActivity(), LoginContract.View {

    private lateinit var toRegisterButton: Button
    private lateinit var submitLoginButton: Button
    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var presenter: LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        this.presenter = LoginPresenter(this)
        initView()
    }

    override fun initView() {
        this.toRegisterButton = findViewById(R.id.toRegisterButton)
        this.submitLoginButton = findViewById(R.id.loginFormButton)
        this.emailEditText = findViewById(R.id.emailLoginEditText)
        this.passwordEditText = findViewById(R.id.pswdLoginEditText)

        this.toRegisterButton.setOnClickListener{
            Log.i("click", "To Register")
            var intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        this.submitLoginButton.setOnClickListener{
            this.submitLogin()
        }
    }

    private fun submitLogin(){
        when{
            this.emailEditText.text.isBlank() -> Log.i("validation", "Email Required")
            this.passwordEditText.text.isBlank() -> Log.i("validation", "Password Required")
            else -> presenter.submitLogin(this.emailEditText.text.toString(), this.passwordEditText.text.toString())
        }
    }

    override fun onSuccessLogin() {
        Log.i("api", "Success Login")
        val intent = Intent(applicationContext, MainActivity::class.java)
        ToastGlobal(applicationContext, "Success Login").success()
        finishAffinity()
        startActivity(intent)
    }
    
    override fun onError(message:String?){
        ToastGlobal(this, message).failed()
    }
}