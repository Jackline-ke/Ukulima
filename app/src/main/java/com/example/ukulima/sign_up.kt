package com.example.ukulima

import android.os.Bundle
import android.text.Layout
import android.text.TextUtils
import android.util.Patterns
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import com.example.ukulima.databinding.FragmentSignUpBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase


class sign_up : Fragment() {

    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var binding: FragmentSignUpBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_sign_up, container, false)
        binding = FragmentSignUpBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.signUpButton.setOnClickListener {
            when{
                TextUtils.isEmpty(binding.editFname.text.toString().trim{it <= ' '}) ->{
                    binding.editFname.error = "First Name Needed!"
                }
                TextUtils.isEmpty(binding.editLname.text.toString().trim{it <= ' '}) ->{
                    binding.editLname.error = "Last Name Needed!"
                }
                TextUtils.isEmpty(binding.editContact.text.toString().trim{it <= ' '}) ->{
                    binding.editContact.error = "Phone Number Needed!"
                }
                TextUtils.isEmpty(binding.editEmail.text.toString().trim{it <= ' '}) ->{
                    binding.editEmail.error = "Email Needed!"
                }
                TextUtils.isEmpty(binding.editPassword.text.toString().trim{it <= ' '}) ->{
                    binding.editPassword.error = "Password Needed!"
                }
                !Patterns.EMAIL_ADDRESS.matcher(binding.editEmail.text.toString()).matches() -> {
                    binding.editEmail.error = "Correct Email Address Required!"
                }
                binding.editPassword.text.toString().length < 8 -> {
                    binding.editPassword.error = "Strong Password Needed!"
                }
                else -> {
                    firebaseAuth.createUserWithEmailAndPassword(binding.editEmail.text.toString(), binding.editPassword.text.toString())
                        .addOnCompleteListener { task ->
                            if (task.isSuccessful){
                                val userModel = User_Model(firebaseAuth.currentUser?.uid.toString(),binding.editFname.text.toString(),binding.editLname.text.toString(),binding.editContact.text.toString(),binding.editEmail.text.toString())
                                firebaseAuth.currentUser?.let { it ->
                                    FirebaseDatabase.getInstance("https://ukulima-ebf9b-default-rtdb.firebaseio.com/").getReference("users")
                                        .child(it.uid)
                                        .setValue(userModel).addOnCompleteListener { task ->
                                            if (task.isSuccessful){
                                                Toast.makeText(
                                                    requireContext(),
                                                    "Registered",
                                                    Toast.LENGTH_SHORT
                                                ).show()
                                            }else{
                                                Toast.makeText(
                                                    requireContext(),
                                                    "Failed",
                                                    Toast.LENGTH_SHORT
                                                ).show()
                                            }
                                        }
                                }

                                Navigation.findNavController(view).navigate(R.id.action_sign_up_to_login)

                            }else{
                                Toast.makeText(
                                    requireContext(),
                                    "Something went wrong. Try again later.",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        }

                    }

                }
            }
                 binding.textHaveAccount.setOnClickListener{
                     Navigation.findNavController(view).navigate(R.id.action_sign_up_to_login)
            }
        return view
    }

}