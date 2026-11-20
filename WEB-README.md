# Game Weise

Open https://lordfrutos66609.github.io/gaming-ai/ on a phone or desktop. No account, API key or installation required.

## Flow

Choose a game → Guide / Find help / Watch. The 101-game catalog includes Diablo II and a curated selection of popular games across platforms, not a measured global ranking. Search accepts common aliases. Stars save favorites in this browser only. No chat history or search history is saved by the app.

Game selection changes artwork, accent color, guide chapters and search context. Steam catalog artwork comes from the Steam CDN; other covers come from Wikipedia when available. Missing artwork falls back to initials. Artwork remains the property of its respective owners; source links are provided on game pages.

## Guides and help

Diablo II has an original eight-section starter guide. Other games have genre-based starter playbooks, explicitly labeled as general strategy. The app automatically retrieves available Wikipedia references and Wikibooks chapters for the selected game. These are not generated, comprehensive walkthroughs for every game. Source coverage varies.

Find help searches the starter guide and the selected game's Wikipedia/Wikibooks source context, with a few shorthand expansions. It does not search the entire web. Source content opens inside the app, with headings, tables and source attribution. No AI inference is used. Source errors are shown separately from zero results. A source's revision date is not the game's patch date.

Watch includes reviewed creator picks for Diablo II, Minecraft, Elden Ring and Path of Exile, with supporting links. Other games have YouTube discovery links, clearly distinguished from reviewed recommendations. YouTube opens externally.

## Files

- index.html: layout and content-security policy
- app.css: responsive catalog, theme and reader styles
- games.js: curated game metadata
- guides.js: original playbooks and creator references
- app.js: favorites, source retrieval, context search and article reader

The browser contacts Wikimedia and the Steam image CDN. Favorites use localStorage and degrade to session-only behavior when storage is unavailable. Sources are rendered as text and reconstructed elements, not inserted as executable HTML.

## Checks

Run `node tests/web-smoke.cjs` and `node --check app.js`. Smoke tests use a mocked DOM and network and cover catalog uniqueness, favorites, context switching, search scoping and source failures. They do not prove browser layout or live source availability.

The existing Android project remains as legacy source and is not required by the web app. GitHub Pages publishes the static files from main.

## Banner refresh

Larger cinematic banners, responsive typography and genre typography variations. Diablo II uses Resurrected promotional artwork from Nintendo's official store, with an Xbox Wire image fallback; it no longer depends on the Wikipedia API for its cover. Steam heroes try library artwork, then the smaller catalog image. Covers appear only after loading successfully. Decorative themed backgrounds remain when remote artwork is blocked. Wikipedia title redirects are resolved when assigning catalog images. Static asset URLs are versioned to refresh older browser caches.

Image loading and fallback tests use simulated events. Live browser visual verification was unavailable in the build environment.
