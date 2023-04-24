package danapradana.belajarapp.counter.contract

interface CounterContract {
    interface Model{
        fun getCount() : Int
        fun countUp()
    }

    interface Presenter{
        fun getCount(): String
        fun countUp()
    }

    interface View{
        fun initView()
        fun updateView()
    }
}