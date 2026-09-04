/* SkillBridge Warm Signal profile layer: editable demo profile backed by localStorage. */

document.addEventListener("DOMContentLoaded", () => {
  if (!SkillBridge.guardPortalPage()) return;
  const form = document.querySelector("#profile-form");
  const user = SkillBridge.getUser();
  if (!form) return;
  ["fullName", "email", "institution", "course", "year", "role", "interests"].forEach((field) => {
    const input = form.querySelector(`[name=${field}]`);
    if (input) input.value = user[field] || "";
  });
  form.addEventListener("submit", (event) => {
    event.preventDefault();
    const updated = { ...user };
    ["fullName", "email", "institution", "course", "year", "role", "interests"].forEach((field) => { updated[field] = form.querySelector(`[name=${field}]`).value.trim(); });
    SkillBridge.setStored(SkillBridge.STORAGE_KEYS.user, updated);
    SkillBridge.populateUserChrome();
    document.querySelector("[data-profile-status]").textContent = "Saved to this demo browser.";
    SkillBridge.showToast("Profile updated.");
  });
});
