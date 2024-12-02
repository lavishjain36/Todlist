document.addEventListener("DOMContentLoaded", () => {
  const form = document.querySelector("form");

  form.addEventListener("submit", (event) => {
    const title = document.getElementById("title").value.trim();
    const status = document.getElementById("status").value;

    let isValid = true;
    let errorMessage = "";

    if (!title) {
      isValid = false;
      errorMessage += "Title is required.\n";
    }

    if (!["PENDING", "IN_PROGRESS", "COMPLETED"].includes(status)) {
      isValid = false;
      errorMessage += "Invalid status selected.\n";
    }

    if (!isValid) {
      alert(errorMessage);
      event.preventDefault(); // Prevent form submission if invalid
    }
  });
});