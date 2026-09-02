import { createFileRoute, redirect } from "@tanstack/react-router";

/**
 * The C2C prototype is plain HTML/CSS/JS living in `public/frontend/`.
 * "/" simply forwards to that static landing page so the preview opens it.
 */
export const Route = createFileRoute("/")({
  head: () => ({
    meta: [
      { title: "C2C — Bridge the Gap Between Academia and Industry" },
      {
        name: "description",
        content:
          "C2C connects students, academia and industry for skill mapping, skill gap analysis, internships and placements.",
      },
      { property: "og:title", content: "C2C — Academia–Industry Collaboration Portal" },
      {
        property: "og:description",
        content:
          "Skill assessment, gap analysis, internships, placements and analytics in one student-built portal.",
      },
      { property: "og:type", content: "website" },
      { name: "twitter:card", content: "summary_large_image" },
    ],
  }),
  beforeLoad: () => {
    throw redirect({ href: "/frontend/index.html" });
  },
  component: () => null,
});
