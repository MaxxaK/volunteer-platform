//import { useEffect, useState } from "react";

// function App() {

//   const [message, setMessage] = useState("loading...");

//   useEffect(() => {
//     fetch("http://localhost:8080/api/test")
//       .then(res => res.text())
//       .then(data => console.log("Response:", data))
//       .catch(err => console.error("Fetch error:", err));
//   }, []);

//   return <h1>React is working</h1>;
// }

import Login from "./pages/Login";
import Register from "./pages/Register";
import { useState } from "react";

export default function App() {

    const [showLogin, setShowLogin] = useState(true);

    return (
        <>
            <button onClick={() => setShowLogin(true)}>
                Login
            </button>

            <button onClick={() => setShowLogin(false)}>
                Register
            </button>

            {showLogin ? <Login /> : <Register />}
        </>
    );
}

// function App() {
//   return <h1>React is working</h1>;
// }

// export default App;

// import { useEffect, useState } from "react";

// function App() {
//   const [message, setMessage] = useState("");

//   useEffect(() => {
//     fetch("http://localhost:8080/api/test")
//       .then(res => res.text())
//       .then(data => setMessage(data));
//   }, []);

//   return <h1>{message}</h1>;
// }

//export default App;