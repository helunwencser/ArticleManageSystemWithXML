let $authors := (doc("records.xml")/dblp/article/author) 
let $unique_authors := distinct-values($authors)
for $author in $unique_authors
	return <author>{$author}</author>
