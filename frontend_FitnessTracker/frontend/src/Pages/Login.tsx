import {Button, responsiveFontSizes, TextField} from "@mui/material"
import { loginButtonStyle, parentDivStyle } from "./Login.styles"
import React, {useEffect} from "react";
import axios from "axios";
import { useNavigate } from "react-router-dom";


export const Login = (): JSX.Element => {
    const [email, setEmail] = React.useState<string>("");
    const [password, setPassword] = React.useState<string>("");
    const [firstNameValue, setFirstNameValue] = React.useState<string>(""); //
    const navigate = useNavigate();

    const onChangeEmail = (event: any): void => {
        setEmail(event.target.value)
    }

    const onChangePassword = (event: any): void => {
        setPassword(event.target.value)
    }

    ///
    const onChangeFirstName = (event: any): void =>
    {
        setFirstNameValue(event.target.value)
    }

    const login = (event: any): void => {
        navigate("/Home")
    }

    // asta ii un exemplu, nu ii ceva practic din back end
    useEffect(()=>{
        const newClient = {
            firstName:firstNameValue // campurile de aici sa fie 1 la 1 cu campurile din back end
        }
        axios.post("http://localhost:8080/Exercise/Insert", newClient, { // axios.get() si nu am cliendId
            headers: {
                "content-type": "application/json"
            }
        }).then((response:any)=>{
            console.log(response.data); // aici se returneaza ce am trimis din back end
        }).catch((error:any)=>
        {
            console.log(error.response.data) // aici se returneaza eroare din back end
        });
    }, [firstNameValue]) // daca nu pun lista de dependinte se apeleaza useEffectul intruna. Doar cand se modifica valoarea
                                // din use Effect, doar atunci se apeleaza. Daca nu pui lista de dependinte, s-ar putea sa se apeleze back-endul intruna si sa se opreasca laptopul.

    return <div style={parentDivStyle}>
        <div style={{ marginTop: 20 }}>
            <TextField id="standard-basic" label="Standard" variant="standard" onChange={onChangeEmail} />
        </div>
        <div style={{ marginTop: 20 }}>
            <TextField id="standard-basic" label="Standard" variant="standard" onChange={onChangePassword} />
        </div>
        <Button style={loginButtonStyle} onClick={login} variant="contained">Login</Button>
    </div>
}

