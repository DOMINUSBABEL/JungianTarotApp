import re

with open("app/src/main/java/com/jungiantarot/presentation/astrology/BirthChartScreen.kt", "r") as f:
    content = f.read()

content = content.replace("chartData = engine.generateAstrologyChart(\"Leo\", \"Escorpio\", \"Acuario\")", "chartData = engine.calculateAstrologyChart(fecha, hora, lugar)")

with open("app/src/main/java/com/jungiantarot/presentation/astrology/BirthChartScreen.kt", "w") as f:
    f.write(content)
