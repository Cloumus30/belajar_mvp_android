package danapradana.belajarapp.counter.model

import danapradana.belajarapp.counter.contract.CounterContract

class Counter : CounterContract.Model {
    private var count : Int = 0
    override fun getCount(): Int {
        return count
    }

    override fun countUp() {
        count++
    }

}