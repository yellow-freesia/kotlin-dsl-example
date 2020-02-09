import java.time.ZonedDateTime

class Account {
    lateinit var username: String
    lateinit var password: String
    lateinit var createdAt: ZonedDateTime
    lateinit var country: String

    val createdNow: Unit
        get() {
            createdAt = ZonedDateTime.now()
        }

    val korea: Unit
        get() {
            country = "Korea"
        }

    fun username(init: () -> String) {
        username = init()
    }

    fun password(init: () -> String) {
        this.password = init()
    }

    override fun toString(): String {
        return "Account(username='$username', password='$password', createdAt=$createdAt, country='$country')"
    }
}

fun account(init: Account.() -> Unit): Account {
    /**
     * 다음 두 가지 모두 가능
     * 1. extension을 사용: account.init()
     * 2. 인자로 입력 받기: init(account)
     *
     * 1번에 의하여 다음이 가능하다.
     * fun account(init: Account.() -> Unit) = Account().also(init)
     *
     * 2번에 의하여 다음이 가능하다.
     * fun account(init: Account.() -> Unit) = Account().apply(init)
     */
    val account = Account()
    account.init()
    return account
}
