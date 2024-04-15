function checkGuess() {
    var guessInput = document.getElementById("guessInput");
    var guess = parseInt(guessInput.value);
    
    if (isNaN(guess)) {
        document.getElementById("message").innerText = "Please enter a valid number.";
        return;
    }
    
    var url = "/check?guess=" + guess; // Assuming your server is running on the same host
    
    fetch(url)
    .then(response => response.json())
    .then(data => {
        document.getElementById("message").innerText = data.message;
    })
    .catch(error => {
        console.error("Error:", error);
    });
}
