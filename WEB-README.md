# Lootwise web reader

The published GitHub Pages app now reads source material inside the website. There is no AI, API key, user account, analytics, or persistent app storage.

## Features
- Searches English Wikipedia and Wikibooks concurrently, eight results per source per page.
- Source filters, independent source errors, pagination, safe text snippets.
- In-app game article and guide chapter reader with headings, tables, lists, optional image, source revision, attribution and related article navigation.
- Timeouts, cancellation and request ordering prevent stale replies replacing newer searches.
- Remote HTML is parsed into an inert document and reconstructed as plain text elements. It is never inserted as executable HTML.

## Limits
This is a two-source reader, not a general search engine or a verified gaming database. Many exact items, recipes, builds and patches are absent. Search uses source keyword matching rather than natural-language question answering. Images and timestamps are optional; article reading works without them. Long articles and tables are visibly shortened. External sources can block or fail requests. The browser makes live requests directly to Wikimedia; successful mocked tests do not prove live connectivity.

Deploy main / root in GitHub Pages. Files: index.html, app.css, app.js. No build dependencies. The old Android source remains separate and its workflow is manual.

Source API documentation: https://www.mediawiki.org/wiki/API:Cross-site_requests
