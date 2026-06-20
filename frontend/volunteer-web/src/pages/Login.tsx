import {useState} from "react";

//Test Email: maxtest@gmail.com
//Test Password: MaxTest123!

export default function Login() {

    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");

    const handleLogin = async () => {
        try {
            const response = await fetch(
                "http://localhost:8080/api/auth/login",
                {
                    method: "POST",
                    headers: {
                        "Content-Type": "application/json",
                    },
                    body: JSON.stringify({
                        email,
                        password,
                    }),
                }
            );

            const user = await response.json();

            console.log("Logged in:", user);

        } catch (error) {
            console.error(error);
        }
    };

    return (
        <>
            <h1>Login Page</h1>

            <input 
                type="text"
                placeholder="Email"
                value={email}
                onChange={(e) => setEmail(e.target.value)} 
            />

            <input 
                type="text"
                placeholder="Password"
                value={password}
                onChange={(e) => setPassword(e.target.value)} 
            />

            <button onClick={handleLogin}>
                Login
            </button>
        </>
    )
}