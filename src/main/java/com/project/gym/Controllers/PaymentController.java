package com.project.gym.Controllers;

import com.project.gym.Model.User;
import com.project.gym.Repos.UserRepository;
import com.project.gym.Response.Response;
import com.project.gym.Services.StripeService;
import com.project.gym.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;
import java.util.Calendar;
import java.util.Date;

@Controller
@RequestMapping("/profile/payment")
public class PaymentController {


    @Value("${stripe.keys.public}")
    private String API_PUBLIC_KEY;

    private StripeService stripeService;

    public PaymentController(StripeService stripeService) {
        this.stripeService = stripeService;
    }

    @GetMapping("")
    public String chooseType(){
        return "chooseCharge";
    }

    @GetMapping("/chargeMonth")
    public String chargePage(Model model) {
        model.addAttribute("stripePublicKey", API_PUBLIC_KEY);
        return "charge";
    }

    @PostMapping("/create-charge-month")
    public @ResponseBody
    Response createCharge(String email, String token) {
        //validate data
        if (token == null) {
            return new Response(false, "Stripe payment token is missing. Please, try again later.");
        }

        //create charge
        String chargeId = stripeService.createCharge(email, token, 999); //$9.99 USD
        if (chargeId == null) {
            return new Response(false, "An error occurred while trying to create a charge.");
        }
        stripeService.addUserMonth(email);

        return new Response(true, "Success! Your charge id is " + chargeId);
    }

    @GetMapping("/chargeYear")
    public String chargePageYear(Model model) {
        model.addAttribute("stripePublicKey", API_PUBLIC_KEY);
        return "chargeYear";
    }

    @PostMapping("/create-charge-year")
    public @ResponseBody
    Response createChargeYear(String email, String token) {
        //validate data
        if (token == null) {
            return new Response(false, "Stripe payment token is missing. Please, try again later.");
        }

        //create charge
        String chargeId = stripeService.createCharge(email, token, 10000); //$100.00 USD
        if (chargeId == null) {
            return new Response(false, "An error occurred while trying to create a charge.");
        }
        stripeService.addUserYear(email);

        return new Response(true, "Success! Your charge id is " + chargeId);
    }

}
