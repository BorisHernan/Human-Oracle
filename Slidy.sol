// Contrato Inteligente de Predicción de Mercado con Human Oracle
pragma solidity ^0.8.0;

contract MarketPrediction {
    address public oracle;
    string public market;
    uint256 public targetPrice;

    event NewPrediction(string prediction);

    constructor(address _oracle, string memory _market, uint256 _targetPrice) {
        oracle = _oracle;
        market = _market;
        targetPrice = _targetPrice;
    }

    // Función para que el Oracle actualice la predicción
    function updatePrediction(string memory newPrediction) public {
        require(msg.sender == oracle, "Solo el Oracle puede actualizar la predicción");

        // Implementar lógica adicional, por ejemplo, comparar la predicción con el objetivo
        require(keccak256(abi.encodePacked(newPrediction)) == keccak256(abi.encodePacked("Alcista")), "Predicción incorrecta");

        // Emitir evento para notificar la nueva predicción
        emit NewPrediction(newPrediction);
    }

    // Función para que los usuarios verifiquen si se alcanzó el objetivo
    function checkPredictionOutcome() public view returns (bool) {
        // Implementar lógica adicional, por ejemplo, comparar el precio actual con el objetivo
        // Devolver true si se alcanzó el objetivo, false de lo contrario
        return true;
    }
}
