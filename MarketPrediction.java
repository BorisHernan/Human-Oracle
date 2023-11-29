package com.gestion.activities.web;

public class MarketPrediction {
    private String oracle;
    private String market;
    private int targetPrice;

    public MarketPrediction(String oracle, String market, int targetPrice) {
        this.oracle = oracle;
        this.market = market;
        this.targetPrice = targetPrice;
    }

    public void updatePrediction(String newPrediction, String sender) {
        if (!sender.equals(oracle)) {
            throw new RuntimeException("Solo el Oracle puede actualizar la predicción");
        }

        // Implementar lógica adicional: comparar la predicción con el objetivo
        if (!newPrediction.equals("Alcista")) {
            throw new RuntimeException("Predicción incorrecta");
        }

        // Emitir evento para notificar la nueva predicción
        System.out.println("Nueva predicción: " + newPrediction);
    }

    public boolean checkPredictionOutcome(int currentPrice) {
        // Implementar lógica adicional: comparar el precio actual con el objetivo
        // Devolver true si se alcanzó el objetivo, false de lo contrario
        return currentPrice >= targetPrice;
    }

    public static void main(String[] args) {
        // Ejemplo de uso
        String oracleAddress = "0x123..."; // Dirección simulada del Oracle
        String marketName = "Bitcoin";
        int targetPrice = 50000;

        MarketPrediction predictionContract = new MarketPrediction(oracleAddress, marketName, targetPrice);

        System.out.println("Caso 1: Actualizar la predicción con el Oracle correcto y una predicción válida");
        try {
            predictionContract.updatePrediction("Alcista", oracleAddress);
        } catch (RuntimeException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println(" Caso 2: Intentar actualizar la predicción con un remitente incorrecto ");
        try {
            predictionContract.updatePrediction("Bajista", "0x456...");
        } catch (RuntimeException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println( " Caso 3: Verificar si se alcanzó el objetivo (supongamos que el precio actual es 51000) ");
        boolean outcome = predictionContract.checkPredictionOutcome(51000);
        System.out.println("¿Se alcanzó el objetivo? " + outcome);
    }
}

