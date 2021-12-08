package com.example.ukulima

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import com.example.ukulima.databinding.FragmentLoginBinding
import com.google.firebase.auth.FirebaseAuth
import java.util.zip.InflaterInputStream


class login : Fragment() {

    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_login, container, false)

        binding = FragmentLoginBinding.inflate(inflater, container, false)
        val view = binding.root

        //validation
        binding.loginButton.setOnClickListener {
            when{
                TextUtils.isEmpty(binding.editEmailLogin.text.toString().trim{it <=' '}) ->{
                    binding.editEmailLogin.error = "Email Needed!"
                }
                TextUtils.isEmpty(binding.editPassword.text.toString().trim{it <=' '}) ->{
                    binding.editPassword.error = "Password Needed!"
                }
                !Patterns.EMAIL_ADDRESS.matcher(binding.editEmailLogin.text.toString()).matches() ->{
                    binding.editEmailLogin.error = "Correct Email Needed"
                }
                binding.editPassword.text.toString().length < 8 -> {
                    binding.editPassword.error = "Strong Password Needed"
                } else -> {
                    firebaseAuth.signInWithEmailAndPassword(binding.editEmailLogin.text.toString(), binding.editPassword.text.toString())
                        .addOnCompleteListener { task ->
                            if (task.isSuccessful){
                                val intent = Intent(requireActivity(), MainActivity::class.java)
                                startActivity(intent)
                            }else{
                                Toast.makeText(
                                    requireContext(),
                                    "Something went wrong \n Please check your details \n or sign up",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        }
                }

            }
        }
        binding.textNoAccount.setOnClickListener{
            Navigation.findNavController(view).navigate(R.id.action_login_to_sign_up)
        }

        return view


    }


}