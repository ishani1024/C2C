/* SkillBridge Warm Signal auth layer: simulated identity storage only; ready for future /api/auth integration. */

document.addEventListener("DOMContentLoaded", () => {
  const user = SkillBridge.getUser();
  const loginForm = document.querySelector("#login-form");
  const registerForm = document.querySelector("#register-form");
  const demoButton = document.querySelector("[data-demo-login]");

  if (loginForm) {
    loginForm.addEventListener("submit", (event) => {
      event.preventDefault();
      const email = loginForm.querySelector("[name=email]");
      const password = loginForm.querySelector("[name=password]");
      if (!email.value.trim() || !password.value.trim()) {
        markInvalid(email, !email.value.trim());
        markInvalid(password, !password.value.trim());
        setStatus("Add your email and password to continue.");
        return;
      }
      localStorage.setItem(SkillBridge.STORAGE_KEYS.session, "active");
      setStatus("Signed in — taking you to your workspace.", true);
      window.setTimeout(() => { window.location.href = "dashboard.html"; }, 500);
    });
  }

  if (demoButton) {
    demoButton.addEventListener("click", () => {
      SkillBridge.setStored(SkillBridge.STORAGE_KEYS.user, SkillBridge.defaultUser);
      localStorage.setItem(SkillBridge.STORAGE_KEYS.session, "active");
      setStatus("Demo student ready — opening workspace.", true);
      window.setTimeout(() => { window.location.href = "dashboard.html"; }, 450);
    });
  }

  if (registerForm) {
    registerForm.addEventListener("submit", (event) => {
      event.preventDefault();
      const fields = [...registerForm.querySelectorAll("[required]")];
      let valid = true;
      fields.forEach((field) => {
        const empty = !field.value.trim();
        markInvalid(field, empty);
        valid = valid && !empty;
      });
      const password = registerForm.querySelector("[name=password]");
      const confirm = registerForm.querySelector("[name=confirmPassword]");
      if (password.value.length < 6) { markInvalid(password, true, "Use at least 6 characters."); valid = false; }
      if (password.value !== confirm.value) { markInvalid(confirm, true, "Passwords should match."); valid = false; }
      if (!valid) { setStatus("Review the highlighted fields and try again."); return; }
      const nextUser = {
        fullName: registerForm.querySelector("[name=fullName]").value.trim(),
        email: registerForm.querySelector("[name=email]").value.trim(),
        institution: registerForm.querySelector("[name=institution]").value.trim(),
        course: registerForm.querySelector("[name=course]").value.trim(),
        year: registerForm.querySelector("[name=year]").value,
        role: registerForm.querySelector("[name=role]").value,
        interests: "",
        skills: ["Java", "Python", "Communication"]
      };
      SkillBridge.setStored(SkillBridge.STORAGE_KEYS.user, nextUser);
      localStorage.setItem(SkillBridge.STORAGE_KEYS.session, "active");
      setStatus("Account created — opening your workspace.", true);
      window.setTimeout(() => { window.location.href = "dashboard.html"; }, 500);
    });
  }

  function markInvalid(field, invalid, customMessage = "This field is required.") {
    const wrapper = field.closest(".form-field");
    if (!wrapper) return;
    wrapper.classList.toggle("invalid", invalid);
    const error = wrapper.querySelector(".field-error");
    if (error && invalid) error.textContent = customMessage;
    field.addEventListener("input", () => wrapper.classList.remove("invalid"), { once: true });
  }

  function setStatus(message, success = false) {
    const status = document.querySelector(".form-status");
    if (!status) return;
    status.textContent = message;
    status.style.color = success ? "var(--primary)" : "var(--brown)";
  }
});
