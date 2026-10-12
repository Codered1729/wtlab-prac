const $ = id => document.getElementById(id);
const msg = text => $("msg").innerText = text;

$("reg").onsubmit = function(e) {
    e.preventDefault();

    let user = {
        name: $("name").value.trim(),
        email: $("email").value.trim(),
        password: $("pass").value
    };

    if (user.name.length < 3 || user.password.length < 6)
        return msg("Invalid name or password!");

    msg("Registration successful!");
};

$("login").onsubmit = function(e) {
    e.preventDefault();

    if ($("lemail").value === $("email").value &&
        $("lpass").value === $("pass").value)
        msg("Login successful!");
    else
        msg("Invalid login details!");
};

$("profile").onsubmit = function(e) {
    e.preventDefault();

    let profile = {
        age: Number($("age").value),
        phone: $("phone").value
    };

    if (profile.age < 18 || !/^\d{10}$/.test(profile.phone))
        return msg("Enter valid age and 10-digit phone!");

    msg("Profile updated successfully!");
};

$("payment").onsubmit = function(e) {
    e.preventDefault();

    let payment = {
        amount: Number($("amount").value),
        method: $("method").value
    };

    if (payment.amount <= 0 || !payment.method)
        return msg("Enter valid payment details!");

    msg("Payment details validated successfully!");
};
