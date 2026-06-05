import { useEffect, useState } from "react";

function App() {

  const [message, setMessage] = useState("loading...");

  useEffect(() => {
    fetch("http://localhost:8080/api/test")
      .then(res => res.text())
      .then(data => console.log("Response:", data))
      .catch(err => console.error("Fetch error:", err));
  }, []);

  return <h1>React is working</h1>;
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

export default App;