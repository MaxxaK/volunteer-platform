import { useState } from "react";

export default function Register() {

    const [username, setUsername] = useState("");
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");
    const handleClick = async () => {
        try {
            const response = await fetch("http://localhost:8080/api/auth/register",
                {
                    method:"POST",
                    headers: {
                        "Content-Type": "application/json"
                    },
                    body: JSON.stringify({
                        username,
                        email,
                        password
                    }),
                }
            );

            if(!response.ok) {
                throw new Error('HTTP Error: ${response.status}');
            }

            const user = await response.json();

            console.log("Registered user: ", user);

        } catch (error){
            console.error("Registration failed.");
        }
    };

    return (
        <>
            <h1>Register Page</h1>

            <input
                type="text"
                placeholder="Username"
                value={username}
                onChange={(e) => setUsername(e.target.value)}
            />

            <input
                type="text"
                placeholder="Email"
                value={email}
                onChange={(e) => setEmail(e.target.value)}
            />

            <input
                type="password"
                placeholder="Password"
                value={password}
                onChange={(e) => setPassword(e.target.value)}
            />

            <button onClick={(handleClick)}>
                Register
            </button>
        </>
    );
}
