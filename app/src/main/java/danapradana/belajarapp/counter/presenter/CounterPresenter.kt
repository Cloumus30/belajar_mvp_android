package danapradana.belajarapp.counter.presenter

import danapradana.belajarapp.counter.contract.CounterContract
import danapradana.belajarapp.counter.model.Counter

class CounterPresenter(_view: CounterContract.View) : CounterContract.Presenter {

    protected var view : CounterContract.View = _view
    protected  var model: Counter = Counter()

    override fun getCount(): String {
        var count = model.getCount()
        return count.toString()
    }

    override fun countUp() {
        model.countUp()
        view.updateView()
    }
}