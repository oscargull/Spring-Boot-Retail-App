import './LoginForm.css';
import {useState} from "react";
import {useNavigate} from "react-router-dom";

const LoginForm = () => {

    const navigate = useNavigate();
    const [loginData, setLoginData] = useState({ username: '', password: ''});
    const [error, setError] = useState('');

    async function handleSubmit(e) {
        e.preventDefault();

        try {
            const response = await fetch('/api/login', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                    'Accept': 'application/json'
                },
                body: JSON.stringify({
                    username: loginData.username,
                    password: loginData.password }),
                });

            if (!response.ok) {
                if (response.status === 401) {
                    const errorMsg = await response.text()
                    setError(errorMsg);
                    console.log('error msg', errorMsg);
                    throw new Error(error);
                    //throw new Error(errorData.message || 'Invalid credentials');
                }
            }
            const data = await response.json();
            localStorage.setItem('token', data.token);

            console.log('Success:', data);

            navigate("/home");

        }catch (e){
            console.error('Error: ', e);
        }
    }

    return(
        <div className={"login-form"}>
            <form id={"loginForm"} onSubmit={handleSubmit}>
                <label htmlFor={"username"}/>
                <input type="text"
                       name="username"
                       value={loginData.username}
                       onChange={(e) => setLoginData({...loginData, username: e.target.value})}
                       placeholder="Enter username"/>
                <label htmlFor={"password"}/>
                <input type="password"
                       name="password"
                       value={loginData.password}
                       onChange={(e) => setLoginData({...loginData, password: e.target.value})}
                       placeholder="choose a password"/>
                {error &&  (<p className={"error"}>{error}</p>)}
                <button type={"submit"} className={"submit-button"}>Submit</button>
                <span className="psw">Forgot <a href="#">password?</a></span>

            </form>
        </div>
    );
}

export default LoginForm;