/* ============================================================
   C2C — Shared frontend helpers
   Mobile navigation, toasts, small render utilities.
   No API calls: this prototype renders from js/mock-data.js only.
   ============================================================ */

/* ---------- Mobile navigation toggle ---------- */
function initNavToggle() {
  const toggle = document.querySelector("[data-nav-toggle]");
  const navbar = document.querySelector("[data-navbar]");
  if (!toggle || !navbar) return;

  toggle.addEventListener("click", () => {
    const open = navbar.classList.toggle("is-open");
    toggle.setAttribute("aria-expanded", String(open));
  });
}

/* ---------- Toast notifications ---------- */
function showToast(message, variant = "") {
  let stack = document.querySelector(".toast-stack");
  if (!stack) {
    stack = document.createElement("div");
    stack.className = "toast-stack";
    stack.setAttribute("role", "status");
    stack.setAttribute("aria-live", "polite");
    document.body.appendChild(stack);
  }
  const toast = document.createElement("div");
  toast.className = "toast" + (variant ? ` toast--${variant}` : "");
  toast.textContent = message;
  stack.appendChild(toast);
  setTimeout(() => toast.remove(), 3500);
}

/* ---------- Landing page: feature cards ---------- */
function renderFeatures(targetId = "featureGrid") {
  const grid = document.getElementById(targetId);
  if (!grid || !window.MockData) return;

  grid.innerHTML = window.MockData.features
    .map(
      (f) => `
      <article class="card card--hover">
        <div class="card-icon card-icon--teal" aria-hidden="true">
          <svg viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2"
               stroke-linecap="round" stroke-linejoin="round">
            <path d="M4 6h16M4 12h10M4 18h7" />
          </svg>
        </div>
        <h3 class="card__title">${f.title}</h3>
        <p class="card__text">${f.text}</p>
      </article>`
    )
    .join("");
}

/* ---------- Role selection cards ---------- */
function renderRoleCards(targetId = "roleGrid") {
  const grid = document.getElementById(targetId);
  if (!grid || !window.MockData) return;

  grid.innerHTML = window.MockData.roles
    .map(
      (role) => `
      <article class="role-card">
        <div class="card-icon" aria-hidden="true">
          <svg viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2"
               stroke-linecap="round" stroke-linejoin="round">
            <circle cx="12" cy="8" r="3.2" />
            <path d="M5 20c0-3.4 3.1-5.5 7-5.5s7 2.1 7 5.5" />
          </svg>
        </div>
        <h3>${role.label}</h3>
        <p class="card__text">${role.description}</p>
        <ul>${role.benefits.map((b) => `<li>${b}</li>`).join("")}</ul>
        <button class="btn btn--primary" type="button" data-role="${role.id}">
          Continue as ${role.label}
        </button>
      </article>`
    )
    .join("");

  grid.addEventListener("click", (event) => {
    const button = event.target.closest("[data-role]");
    if (button) selectRole(button.dataset.role);
  });
}

/* Remembers the chosen role for the (upcoming) dashboards.
   Dashboards are built in a later stage, so we route to a notice page. */
function selectRole(roleId) {
  const role = window.MockData.roles.find((r) => r.id === roleId);
  if (!role) return;
  sessionStorage.setItem("c2c_demo_role", roleId);
  window.location.href = `coming-soon.html?role=${encodeURIComponent(role.label)}`;
}

/* ---------- Footer year ---------- */
function setFooterYear() {
  document.querySelectorAll("[data-year]").forEach((el) => {
    el.textContent = String(new Date().getFullYear());
  });
}

document.addEventListener("DOMContentLoaded", () => {
  initNavToggle();
  setFooterYear();
  renderFeatures();
  renderRoleCards();
});

window.C2C = { showToast, selectRole };
