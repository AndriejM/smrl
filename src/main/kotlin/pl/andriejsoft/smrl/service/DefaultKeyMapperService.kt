package pl.andriejsoft.smrl.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional
import pl.andriejsoft.smrl.model.Link
import pl.andriejsoft.smrl.model.repositories.LinkRepository
import java.util.concurrent.ConcurrentHashMap

@Component
class DefaultKeyMapperService : KeyMapperService {

    @Autowired
    lateinit var converter: KeyConverterService

    @Autowired
    lateinit var repo: LinkRepository


    private val map: MutableMap<Long, String> = ConcurrentHashMap();

    @Transactional
    override fun add(link: String) = converter.idToKey(repo.save(Link(link)).id)


    override fun getLink(key: String) : KeyMapperService.Get {
        val result = repo.findById(converter.keyToId(key))
        return if (result.isPresent) {
            KeyMapperService.Get.Link(result.get().text)
        } else {
            KeyMapperService.Get.NotFound(key);
        }

    }
}