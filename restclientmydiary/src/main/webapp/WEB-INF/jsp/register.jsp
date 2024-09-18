<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registration Form</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }

        .form-container {
            background-color: #fff;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            width: 300px;
        }

        .form-container h2 {
            text-align: center;
            margin-bottom: 20px;
            color: #333;
        }

        .form-container label {
            display: block;
            margin-bottom: 8px;
            font-weight: bold;
            color: #333;
        }

        .form-container input[type="text"],
        .form-container input[type="password"],
        .form-container select {
            width: 100%;
            padding: 10px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-sizing: border-box;
        }

        .form-container input[type="submit"],
        .form-container input[type="button"] {
            width: 100%;
            padding: 10px;
            border: none;
            border-radius: 5px;
            background-color: #28a745;
            color: #fff;
            font-size: 16px;
            cursor: pointer;
            margin-bottom: 10px;
        }

        .form-container input[type="submit"]:hover,
        .form-container input[type="button"]:hover {
            background-color: #218838;
        }

        .form-container .login-btn {
            background-color: #007BFF;
        }

        .form-container .login-btn:hover {
            background-color: #0056b3;
        }

        .form-container .extra-links {
            text-align: center;
            margin-top: 10px;
        }

        .form-container .extra-links a {
            color: #007BFF;
            text-decoration: none;
            font-size: 14px;
        }

        .form-container .extra-links a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <div class="form-container">
        <h2>Register</h2>
        <form action="./SRF" method="post">
            <label for="username">Username:</label>
            <input type="text" id="username" name="username" placeholder="Enter your username" required />

            <label for="password">Password:</label>
            <input type="password" id="password" name="password" placeholder="Enter your password" required />

            <label for="confirm-password">Confirm Password:</label>
            <input type="password" id="confirm-password" name="confirm-password" placeholder="Confirm your password" required />

            <label for="role">Role:</label>
            <select id="role" name="role" required>
                <option value="student">Student</option>
                <option value="teacher">Teacher</option>
                <option value="admin">Admin</option>
            </select>

            <input type="submit" value="Register" />
        </form>

        <input type="button" value="Login" class="login-btn" onclick="window.location.href='./login'" />
    </div>
</body>
</html>