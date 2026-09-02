/* ============================================================
   C2C — Auth UI logic (PROTOTYPE, no backend)
   ------------------------------------------------------------
   Nothing here is real authentication. No credentials are stored
   and no requests are made. Spring Security + REST endpoints will
   replace the two "submit" handlers marked TODO below.
   ============================================================ */

/* ---------- Validation helpers ---------- */
function setFieldError(input, message) {
  const field = input.closest(".field");
  if (!field) return;
  field.classList.add("field--error");
  const box = field.querySelector(".error-text");
  if (box) box.textContent = message;
  input.setAttribute("aria-invalid", "true");
}

function clearFieldError(input) {
  const field = input.closest(".field");
  if (!field) return;
  field.classList.remove("field--error");
  input.removeAttribute("aria-invalid");
}

function isValidEmail(value) {
  return /^[^\s@]+@[^\s@]+\.[^\s@]{2,}$/.test(value.trim());
}

/**
 * Generic form validator.
 * rules: { fieldName: (value, form) => errorMessage | "" }
 * Returns true when the form is valid.
 */
function validateForm(form, rules) {
  let firstInvalid = null;

  Object.keys(rules).forEach((name) => {
    const input = form.elements[name];
    if (!input) return;
    clearFieldError(input);
    const message = rules[name](String(input.value || ""), form);
    if (message) {
      setFieldError(input, message);
      if (!firstInvalid) firstInvalid = input;
    }
  });

  if (firstInvalid) firstInvalid.focus();
  return !firstInvalid;
}

function required(label) {
  return (value) => (value.trim() ? "" : `${label} is required.`);
}

/* ---------- Login page ---------- */
function initLoginForm() {
  const form = document.getElementById("loginForm");
  if (!form) return;

  form.addEventListener("submit", (event) => {
    event.preventDefault();

    const ok = validateForm(form, {
      email: (v) => (!v.trim() ? "Email is required." : !isValidEmail(v) ? "Enter a valid email address." : ""),
      password: (v) => (!v ? "Password is required." : v.length < 6 ? "Password must be at least 6 characters." : ""),
    });
    if (!ok) return;

    // TODO(backend): POST /api/auth/login -> receive JWT, then redirect by role.
    const role = form.elements["role"].value;
    window.C2C.showToast("Demo login accepted — no backend connected.", "success");

    if (role) {
      sessionStorage.setItem("c2c_demo_role", role);
      const label = window.MockData.roles.find((r) => r.id === role)?.label || role;
      setTimeout(() => {
        window.location.href = `coming-soon.html?role=${encodeURIComponent(label)}`;
      }, 600);
    } else {
      setTimeout(() => { window.location.href = "role-selection.html"; }, 600);
    }
  });
}

/* ---------- Register page ---------- */
function renderRoleFields(roleId) {
  const host = document.getElementById("roleFields");
  if (!host) return;
  const fields = window.MockData.roleFields[roleId] || [];

  host.innerHTML = fields
    .map((f) => {
      const id = `f_${f.name}`;
      const control =
        f.type === "select"
          ? `<select class="select" id="${id}" name="${f.name}">
               <option value="">Select…</option>
               ${f.options.map((o) => `<option value="${o}">${o}</option>`).join("")}
             </select>`
          : `<input class="input" type="text" id="${id}" name="${f.name}" placeholder="${f.placeholder || ""}" />`;
      return `<div class="field">
                <label for="${id}">${f.label}</label>
                ${control}
                <p class="error-text" role="alert"></p>
              </div>`;
    })
    .join("");
}

function initRegisterForm() {
  const form = document.getElementById("registerForm");
  if (!form) return;

  // Role radio cards drive the extra fields
  form.querySelectorAll('input[name="role"]').forEach((radio) => {
    radio.addEventListener("change", () => renderRoleFields(radio.value));
  });
  const checked = form.querySelector('input[name="role"]:checked');
  if (checked) renderRoleFields(checked.value);

  form.addEventListener("submit", (event) => {
    event.preventDefault();

    const roleInput = form.querySelector('input[name="role"]:checked');
    const roleId = roleInput ? roleInput.value : "";

    const rules = {
      fullName: (v) => (!v.trim() ? "Full name is required." : v.trim().length < 3 ? "Enter your full name." : ""),
      email: (v) => (!v.trim() ? "Email is required." : !isValidEmail(v) ? "Enter a valid email address." : ""),
      password: (v) => (!v ? "Password is required." : v.length < 8 ? "Use at least 8 characters." : ""),
      confirmPassword: (v, f) => (!v ? "Please confirm your password." : v !== f.elements["password"].value ? "Passwords do not match." : ""),
    };

    // Role-specific fields are all required in this prototype
    (window.MockData.roleFields[roleId] || []).forEach((f) => {
      rules[f.name] = required(f.label);
    });

    const roleAlert = document.getElementById("roleAlert");
    if (!roleId) {
      if (roleAlert) roleAlert.hidden = false;
      return;
    }
    if (roleAlert) roleAlert.hidden = true;

    if (!validateForm(form, rules)) return;

    // TODO(backend): POST /api/auth/register with the collected form data.
    const success = document.getElementById("registerSuccess");
    if (success) {
      success.hidden = false;
      success.scrollIntoView({ block: "center" });
    }
    window.C2C.showToast("Demo registration recorded locally only.", "success");
    sessionStorage.setItem("c2c_demo_role", roleId);
  });
}

/* ---------- Coming-soon notice ---------- */
function initComingSoon() {
  const target = document.getElementById("comingSoonRole");
  if (!target) return;
  const role = new URLSearchParams(window.location.search).get("role")
    || sessionStorage.getItem("c2c_demo_role")
    || "your";
  target.textContent = role;
}

document.addEventListener("DOMContentLoaded", () => {
  initLoginForm();
  initRegisterForm();
  initComingSoon();
});
