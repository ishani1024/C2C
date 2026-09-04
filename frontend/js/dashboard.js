/* SkillBridge Warm Signal dashboard layer: dynamic demo metrics with honest placeholder data. */

document.addEventListener("DOMContentLoaded", () => {
  if (!SkillBridge.guardPortalPage()) return;
  const score = Number(SkillBridge.getStored(SkillBridge.STORAGE_KEYS.assessment, { score: 78 }).score || 78);
  const ring = document.querySelector("[data-score-ring]");
  const scoreLabel = document.querySelector("[data-score-value]");
  if (ring) ring.style.setProperty("--score", score);
  if (scoreLabel) scoreLabel.textContent = `${score}%`;
  document.querySelectorAll("[data-progress]").forEach((track) => {
    const value = track.dataset.progress;
    const fill = track.querySelector("span");
    if (fill) fill.style.width = `${value}%`;
  });
  document.querySelectorAll("[data-start-assessment]").forEach((button) => {
    button.addEventListener("click", () => { window.location.href = "assessment.html"; });
  });
});
