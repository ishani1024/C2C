/* SkillBridge Warm Signal skill-map layer: static demo skill data grouped for future API replacement. */

const technicalSkills = [
  { name: "Java", current: 80, target: 85, relevance: "High" },
  { name: "Python", current: 82, target: 88, relevance: "High" },
  { name: "SQL", current: 65, target: 80, relevance: "High" },
  { name: "HTML / CSS / JavaScript", current: 74, target: 84, relevance: "Medium" },
  { name: "Data structures", current: 58, target: 78, relevance: "High" }
];
const professionalSkills = [
  { name: "Communication", current: 90, target: 92, relevance: "High" },
  { name: "Teamwork", current: 84, target: 88, relevance: "High" },
  { name: "Problem solving", current: 78, target: 86, relevance: "High" },
  { name: "Leadership", current: 61, target: 76, relevance: "Medium" }
];

document.addEventListener("DOMContentLoaded", () => {
  if (!SkillBridge.guardPortalPage()) return;
  document.querySelectorAll("[data-map-progress]").forEach((fill) => { fill.style.width = `${fill.dataset.mapProgress}%`; });
});

window.SkillBridgeSkills = { technicalSkills, professionalSkills };
