package step1

import step1.language.Languages
import step1.language.LanguagesBuilder
import step1.skill.Skills
import step1.skill.SkillsBuilder

class PersonBuilder {
    private var name: String = DEFAULT_NAME
    private var company: String = DEFAULT_COMPANY
    private var skills: Skills = Skills()
    private var languages: Languages = Languages()

    fun name(value: String) {
        this.name = value
    }

    fun company(value: String) {
        this.company = value
    }

    fun skills(block: SkillsBuilder.() -> Unit) {
        this.skills = SkillsBuilder().apply(block).build()
    }

    fun languages(block: LanguagesBuilder.() -> Unit) {
        this.languages = LanguagesBuilder().apply(block).build()
    }
    fun build(): Person {
        return Person(name, company, skills, languages)
    }

    companion object {
        const val DEFAULT_NAME: String = ""
        const val DEFAULT_COMPANY: String = ""
    }
}
