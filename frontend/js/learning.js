/* SkillBridge Warm Signal learning layer: curated demo resources until a future recommendations API is connected. */

document.addEventListener("DOMContentLoaded", () => {
  if (!SkillBridge.guardPortalPage()) return;
  document.querySelectorAll("[data-watch]").forEach((button) => button.addEventListener("click", () => SkillBridge.showToast("This demo resource is ready to connect to a future YouTube or learning API.")));
});
