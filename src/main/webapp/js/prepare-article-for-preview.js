const articlePostForm = document.getElementById("createArticleForm")
const articlePreviewButton = document.getElementById("preview-button")
const articlePreviewLayer = document.getElementById("preview-article")

const articleTitle = document.getElementById("title")
const articleSummary = document.getElementById("summary")
const articleBody = document.getElementById("articleBody")

const h1PreviewTitle = document.getElementById("prepared-preview-title")
const divPreviewSummary = document.getElementById("prepared-preview-summary")
const mdBlockPreviewBody = document.getElementById("prepared-preview-body")

const h1WriteArticlePageTitle = document.getElementById("write-article-page-title")

const continueEditingButton = document.getElementById("continue-editing-button")

articlePreviewButton.addEventListener("click", () => {
    articlePostForm.style.display = "none"
    articlePreviewButton.style.display = "none"
    articlePreviewLayer.style.display = "block"

    h1PreviewTitle.innerHTML = articleTitle.value
    divPreviewSummary.innerHTML = articleSummary.value
    mdBlockPreviewBody.mdContent = articleBody.value

    h1WriteArticlePageTitle.style.display = "none"
})

continueEditingButton.addEventListener("click", () => {
    articlePostForm.style.display = "block"
    articlePreviewButton.style.display = "inline-block"
    articlePreviewLayer.style.display = "none"

    h1WriteArticlePageTitle.style.display = "block"
})