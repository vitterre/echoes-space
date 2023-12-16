const img = document.getElementById("about-img")

let hexString = "12341124123412"

let randomColor = () => {
    let hexCode = "#"
    for (let i = 0; i < 6; i++) {
        hexCode += hexString[Math.floor(Math.random() * hexString.length)]
    }
    return hexCode
}

let colorOne = randomColor()
let colorTwo = randomColor()
let angle = Math.floor(Math.random() * 360)
img.style.background = `linear-gradient(${angle}deg, ${colorOne}, ${colorTwo})`