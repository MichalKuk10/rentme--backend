import React from "react";
import {Link} from "react-router-dom";
import "../../css/header-and-body.css";
import closeIcon from "../../assets/close-window.svg"
import RecoverAcc from "../RecoverAcc/RecoverAcc";
import {useForm} from "react-hook-form";


function Login() {


    const fetchItemDetails = async (data) => {
        console.log("asd");
        await fetch('http://localhost:8080/test', {
            method: 'PUT',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(data),
        });
    }


    const {register, handleSubmit, errors} = useForm();

    const onSubmit = (data) => {
        fetchItemDetails(data.email);
    };

    function hideLogin() {
        document.querySelector(".close").addEventListener("click", function () {
            document.querySelector(".wrapper").style.display = "flex";
            fadeIn("wrapper", 75)
            document.querySelector(".popup").style.display = "none";
        })
    }

    function fadeIn(element, duration) {
        var i = 0;
        var wrapper = document.getElementsByClassName(element)[0];
        wrapper.style.opacity = 0;
        var k = window.setInterval(function () {
            if (i >= 10) {
                clearInterval(k)
                wrapper.style.opacity = 1;
            } else {
                wrapper.style.opacity = i / 10;
                i++;
            }
        }, duration);
    }

    function forgotPass() {
        document.querySelector(".wrapper").style.opacity = "0";
        document.querySelector(".popup").style.display = "none";
        document.querySelector(".popup2").style.display = "flex";
    }


    return (
        <React.Fragment>
            <RecoverAcc/>
            <form onSubmit={handleSubmit(onSubmit)}>
            <div className="popup">
                <div className="popup-content">
                    <h3>Sign in</h3>
                    <img className="close" src={closeIcon} onClick={hideLogin} alt={"close-icon"}/>
                    <h4>E-mail:</h4>
                    <input className="login-data-input" type="text" placeholder="Enter your e-mail" name="email" ref={register({
                        required: "Required",
                        pattern: {
                            value: /^[A-Z0-9._%+-]+@[A-Z0-9.-]+\.[A-Z]{2,}$/i,
                            message: "invalid email address"
                        }
                    })}/>
                    {errors.email && <p>You need to enter valid email address.</p>}
                    <h4>Password:</h4>
                    <input className="login-data-input" type="password" placeholder="Enter your password" name="password" ref={register}/>
                    <button className="recoveryPassBtn" onClick={forgotPass}>forgot your password?</button>
                    <button className="loginRecBtn" >Login</button>
                </div>
            </div>
        </form>
        </React.Fragment>
    );
}

export default Login;