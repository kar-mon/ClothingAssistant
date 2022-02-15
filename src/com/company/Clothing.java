package com.company;

public class Clothing {

    public String wardrobe(Weather checkWeather) {
        String whatToWear = wardrobeByTemp(checkWeather.getTempFeelsLike());
        String whatToTake = waterFromSky(checkWeather);
        String whatToTake2 = sunShine(checkWeather);
        return whatToWear + whatToTake + whatToTake2;
    }

    private String wardrobeByTemp(double temp) {
        if (temp <= -20.0) return wardrobe1;
        else if (temp <= -10.0) return wardrobe2;
        else if (temp <= 0.0) return wardrobe3;
        else if (temp <= 10.0) return wardrobe4;
        else if (temp <= 20.0) return wardrobe5;
        return wardrobe6;
    }

    private String waterFromSky(Weather weather) {
        if (weather.weatherMain == "Rain" || weather.weatherMain == "Snow" || weather.weatherMain == "Drizzle")
            return accessoriesRain;
        return "";
    }

    private String sunShine(Weather weather) {
        if (weather.weatherMain == "Clear") return accessoriesSun;
        return "";
    }

    String wardrobe1 = "merino underwear, woolen socks, sweater or fleece, trousers, fur coat, fur gloves, reindeer fur boots, ushanka, woolen scarf "; //for under -20 degC
    String wardrobe2 = "merino underwear, woolen socks, sweater or fleece, trousers, parka, woolen gloves, woolen hat, woolen scarf, boots "; //for under -10 degC
    String wardrobe3 = "blouse, trousers or skirt and tights, sweater or fleece, winter jacket, hat, scarf, gloves, boots "; //for under 0 degC
    String wardrobe4 = "blouse, trousers or skirt and tights, sweater or fleece, light to medium jacket, hat, shawl , mittens, shoes "; //for under 10 degC
    String wardrobe5 = "blouse, trousers or skirt and tights, sweater,fleece or light jacket, shoes "; //for under 20 degC
    String wardrobe6 = "short sleeves, shorts or skirt, sunglasses "; //for over 20 degC
    String accessoriesRain = "raincoat, rain boots, umbrella ";
    String accessoriesSun = "sunglasses ";


    //public String getClothing(Weather weather){}
}
