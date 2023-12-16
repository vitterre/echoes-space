let hexString = "12341124123412"

const podcastList = document.getElementById("podcasts")
const items = podcastList.getElementsByClassName("podcast-list-element")

let randomColor = () => {
    let hexCode = "#"
    for (let i = 0; i < 6; i++) {
        hexCode += hexString[Math.floor(Math.random() * hexString.length)]
    }
    return hexCode
}

for (let i = 0; i < items.length; i++) {
    let colorOne = randomColor()
    let colorTwo = randomColor()
    let angle = Math.floor(Math.random() * 360)
    let item = items[i].getElementsByClassName("card-img-top")[0]
    item.style.background = `linear-gradient(${angle}deg, ${colorOne}, ${colorTwo})`
}

