
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>View Record</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            background-color: #f7f7f7;
            margin: 0;
            padding: 20px;
        }

        .container {
            max-width: 600px;
            margin: 0 auto;
            background-color: white;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            padding: 20px;
            border-radius: 10px;
        }

        h2 {
            font-size: 1.5em;
            color: #333;
            text-align: center;
        }

        .date {
            font-size: 1.2em;
            font-weight: bold;
            margin-bottom: 20px;
            text-align: center;
        }

        textarea {
            width: 100%;
            height: 150px;
            padding: 10px;
            border-radius: 5px;
            border: 1px solid #ccc;
            font-size: 1em;
            resize: vertical;
        }

        .buttons {
            margin-top: 20px;
            text-align: center;
        }

        .back-button {
            padding: 10px 20px;
            font-size: 1em;
            color: white;
            background-color: #3498db;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }

        .back-button:hover {
            background-color: #2980b9;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>View Record</h2>
        
        <!-- Display the date -->
        <div class="date">
            Date: <fmt:formatDate value="${date}" pattern="yyyy-MM-dd" />
        </div>

        <!-- Editable description in a textarea -->
        <form action="updateRecord" method="post">
            <textarea name="description"> this is description </textarea>

            <!-- Back button -->
            <div class="buttons">
                <button type="button" class="back-button" onclick="window.history.back()">Back</button>
            </div>
        </form>
    </div>
</body>
</html>
