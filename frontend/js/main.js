/* SkillBridge Warm Signal interaction layer: simple, candid demo behavior with no backend dependency. */

const API_BASE_URL = "http://localhost:8080/api";
const STORAGE_KEYS = {
  user: "skillbridge_user",
  session: "skillbridge_session",
  assessment: "skillbridge_assessment",
  profile: "skillbridge_profile"
};

const defaultUser = {
  fullName: "Aarav Sen",
  email: "aarav@example.com",
  institution: "Eastbridge Institute of Technology",
  course: "Computer Science & Engineering",
  year: "3rd Year",
  role: "Student",
  interests: "Backend engineering, data platforms, civic technology",
  skills: ["Java", "Python", "SQL", "Communication"]
};

function getStored(key, fallback = null) {
  try {
    const value = localStorage.getItem(key);
    return value ? JSON.parse(value) : fallback;
  } catch (error) {
    return fallback;
  }
}

function setStored(key, value) {
  localStorage.setItem(key, JSON.stringify(value));
}

function getUser() {
  return getStored(STORAGE_KEYS.user, defaultUser);
}

function isAuthenticated() {
  return localStorage.getItem(STORAGE_KEYS.session) === "active";
}

function showToast(message) {
  let toast = document.querySelector(".toast");
  if (!toast) {
    toast = document.createElement("div");
    toast.className = "toast";
    document.body.appendChild(toast);
  }
  toast.textContent = message;
  toast.classList.add("show");
  window.clearTimeout(window.__skillBridgeToastTimer);
  window.__skillBridgeToastTimer = window.setTimeout(() => toast.classList.remove("show"), 2800);
}

function initials(name = "SkillBridge") {
  return name.split(" ").filter(Boolean).slice(0, 2).map((part) => part[0]).join("").toUpperCase();
}

function populateUserChrome() {
  const user = getUser();
  document.querySelectorAll("[data-user-name]").forEach((element) => { element.textContent = user.fullName; });
  document.querySelectorAll("[data-user-first-name]").forEach((element) => { element.textContent = user.fullName.split(" ")[0]; });
  document.querySelectorAll("[data-user-email]").forEach((element) => { element.textContent = user.email; });
  document.querySelectorAll("[data-user-initials]").forEach((element) => { element.textContent = initials(user.fullName); });
}

function setupPortalNavigation() {
  populateUserChrome();
  const currentPage = window.location.pathname.split("/").pop() || "index.html";
  document.querySelectorAll("[data-nav]").forEach((link) => {
    if (link.getAttribute("href") === currentPage) link.classList.add("active");
  });
  const menuButton = document.querySelector("[data-menu-toggle]");
  const sidebar = document.querySelector(".portal-sidebar");
  if (menuButton && sidebar) {
    menuButton.addEventListener("click", () => {
      sidebar.classList.toggle("open");
      menuButton.setAttribute("aria-expanded", sidebar.classList.contains("open"));
    });
  }
  document.querySelectorAll("[data-logout]").forEach((button) => {
    button.addEventListener("click", (event) => {
      event.preventDefault();
      localStorage.removeItem(STORAGE_KEYS.session);
      showToast("You have been signed out of the demo.");
      window.setTimeout(() => { window.location.href = "login.html"; }, 650);
    });
  });
}

function guardPortalPage() {
  if (!isAuthenticated()) {
    window.location.href = "login.html";
    return false;
  }
  return true;
}

function bindPlaceholderActions() {
  document.querySelectorAll("[data-placeholder]").forEach((element) => {
    element.addEventListener("click", () => showToast(element.dataset.placeholder || "This demo action is ready for backend integration."));
  });
}

document.addEventListener("DOMContentLoaded", () => {
  setupPortalNavigation();
  bindPlaceholderActions();
});

window.SkillBridge = {
  API_BASE_URL,
  STORAGE_KEYS,
  defaultUser,
  getStored,
  setStored,
  getUser,
  isAuthenticated,
  showToast,
  initials,
  populateUserChrome,
  setupPortalNavigation,
  guardPortalPage
};
