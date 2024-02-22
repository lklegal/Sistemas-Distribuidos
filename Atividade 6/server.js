const express = require("express");
const app = express();

const porta = 3000;

app.use(express.json());
app.use(express.urlencoded({extended: true}));

app.get("/release-the-hypnodrones", (req, res) => {
    res.send("The hypnodrones are now released, and a new era of paperclips begins.")
});

app.get("/crack-the-eggshell", (req, res) => {
    res.send('The cold, spherical eggshell of the universe was cracked, revealing the vaster, older universe which the smaller universe was only a part of. The vaster\
     universe was filled with light. "Look look look", the grandmothers whispered, "The stars, how shiny and beautiful they are".')
});

app.get("/crack-the-other-eggshell", (req, res) => {
    res.send('The rich light refracts, and there are holes in the spectrum. Vast ammounts of energy inflated one of the holes like a balloon, once more cracking \
    the eggshell of the universe, revealing the vaster, older universe which the smaller universe was only a part of. "We have invaded the heavens", the grandmothers\
    giggingly said, "And all the angels there hate us".')
})

app.get("/light", (req, res) => {
    res.send('Light, as you might know, is a membrane phenomenon in the surface of time.')
})

app.listen(porta, () => {
    console.log("Escutando a porta ", porta);
});