package noarchtest

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class SchedulerProvider  {
     companion object {
          fun computation() = Schedulers.trampoline()
          fun mainThread() = AndroidSchedulers.mainThread()
          fun io() = Schedulers.io()
     }
}