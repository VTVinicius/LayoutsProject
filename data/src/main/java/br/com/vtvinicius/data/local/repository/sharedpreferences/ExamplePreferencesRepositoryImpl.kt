import br.com.vtvinicius.data.local.datasource.ExamplePreferencesDataSource
import br.com.vtvinicius.domain.repository.sharedPreferences.ExamplePreferencesRepository

class ExamplePreferencesRepositoryImpl(
    private val dataSource: ExamplePreferencesDataSource,
) : ExamplePreferencesRepository {

    override fun saveExample(value: String) {
        dataSource.saveExample(value)
    }

    override fun getExample(): String? {
        return dataSource.getExample()
    }


}