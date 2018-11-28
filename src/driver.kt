
import java.text.DecimalFormat


fun main(args: Array<String>){
    reportFinancialAgeBasedOffOfPercentRule()
}

private fun reportFinancialAgeBasedOffOfExpenses() {
    val returnRate = 1.07
    val initialAmount = 108_765.48
    var currentAmount = initialAmount
    val livingUntilAge = 90
    val annualExpenses = 100_749.49
    val amountSavedAnnually = 75_000
    var currentAge = 27
    while (remainingLifeExpenses(livingUntilAge, currentAge, annualExpenses) > currentAmount) {
        currentAge++
        currentAmount = currentAmount * returnRate
        currentAmount += amountSavedAnnually
    }
    print("I will have financial independence at the age of $currentAge with a total amount of $${currentAmount.converToDecimalFormat()}")
}

private fun reportFinancialAgeBasedOffOfPercentRule(){
    val returnRate = 1.07
    val initialAmount = 108_765.48
    var currentAmount = initialAmount
    val annualExpenses = 100_749.49
    val amountSavedAnnually = 75_000
    var currentAge = 27
    val safeWithdrawalRate = 0.03
    while (annualExpenses / safeWithdrawalRate > currentAmount) {
        currentAge++
        currentAmount *= returnRate
        currentAmount += amountSavedAnnually
    }
    print("I will have financial independence at the age of $currentAge with a total amount of $${currentAmount.converToDecimalFormat()}")
}

fun Double.converToDecimalFormat(): String{
    val decimalFormat = DecimalFormat("#,###")
    return decimalFormat.format(this)
}

private fun remainingLifeExpenses(
    livingUntilAge: Int,
    currentAge: Int,
    annualExpenses: Double
) = (livingUntilAge - currentAge) * annualExpenses