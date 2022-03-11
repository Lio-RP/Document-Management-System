package com.springframework.documentmanagementsystem.bootstrap;

import com.springframework.documentmanagementsystem.models.*;
import com.springframework.documentmanagementsystem.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {
    private final AgreementDocumentsServices agreementDocumentsServices;
    private final ServiceDocumentsServices serviceDocumentsServices;
    private final SignedPersonServices signedPersonServices;
    private final PreparedPersonServices preparedPersonServices;
    private final MessageServices messageServices;

    public DataLoader(AgreementDocumentsServices agreementDocumentsServices,
                      ServiceDocumentsServices serviceDocumentsServices,
                      SignedPersonServices signedPersonServices,
                      PreparedPersonServices preparedPersonServices, MessageServices messageServices) {
        this.agreementDocumentsServices = agreementDocumentsServices;
        this.serviceDocumentsServices = serviceDocumentsServices;
        this.signedPersonServices = signedPersonServices;
        this.preparedPersonServices = preparedPersonServices;
        this.messageServices = messageServices;
    }

    @Override
    public void run(String... args) throws Exception {

        loadData();
    }

    private void loadData() {
        SignedPerson signedPerson = new SignedPerson();
        signedPerson.setFirstName("Liban Abdullahi");
        signedPerson.setLastName("Mohamed");
        signedPerson.setEmail("libanr4243@gmail.com");
        signedPerson.setPhone("+79964426139");
        signedPerson.setPosition("Manager");

        SignedPerson savedSingedPerson = signedPersonServices.save(signedPerson);

        PreparedPerson preparedPerson = new PreparedPerson();
        preparedPerson.setFirstName("Basro Abdulle");
        preparedPerson.setLastName("Abubakar");
        preparedPerson.setEmail("basraabdulle42@gmail.com");
        preparedPerson.setPhone("+252615681777");

        PreparedPerson savedPreparedPerson = preparedPersonServices.save(preparedPerson);

        AgreementDocuments agreementDocuments1 = new AgreementDocuments();
        agreementDocuments1.setRegistrationNumber(1234);
        agreementDocuments1.setRegistrationDate(LocalDate.now());
        agreementDocuments1.setTypeDocument("Agreement");
        agreementDocuments1.setStateDocument("Registering");
        agreementDocuments1.setTypeAgreement("Order Services");
        agreementDocuments1.setDeadlineAgreement(LocalDate.now());
        agreementDocuments1.setContractor("Hormuud Company");
        agreementDocuments1.setAmount(new BigDecimal(2555));
        agreementDocuments1.setSignedPerson(signedPerson);
        agreementDocuments1.setPreparedPerson(preparedPerson);
        agreementDocuments1.setNumberSheets(4);
        agreementDocuments1.setSummery("This is agreement document for ordering service Hormud Company");

        agreementDocumentsServices.save(agreementDocuments1);


        AgreementDocuments agreementDocuments2 = new AgreementDocuments();
        agreementDocuments2.setRegistrationNumber(102);
        agreementDocuments2.setRegistrationDate(LocalDate.now());
        agreementDocuments2.setTypeDocument("Agreement");
        agreementDocuments2.setStateDocument("Registering");
        agreementDocuments2.setTypeAgreement("Order Services");
        agreementDocuments2.setDeadlineAgreement(LocalDate.now());
        agreementDocuments2.setContractor("Somtel Company");
        agreementDocuments2.setAmount(new BigDecimal(25567));
        agreementDocuments2.setSignedPerson(signedPerson);
        agreementDocuments2.setPreparedPerson(preparedPerson);
        agreementDocuments2.setNumberSheets(4);
        agreementDocuments2.setSummery("This is agreement document for ordering service Hormud Company");

        agreementDocumentsServices.save(agreementDocuments2);

        System.out.println("Agreement Documents Loaded....");


        ServiceDocuments serviceDocuments1 = new ServiceDocuments();
        serviceDocuments1.setId(1L);
        serviceDocuments1.setRegistrationNumber(101);
        serviceDocuments1.setRegistrationDate(LocalDate.now());
        serviceDocuments1.setTypeDocument("Service");
        serviceDocuments1.setStateDocument("Registering");
        serviceDocuments1.setSignedPerson(signedPerson);
        serviceDocuments1.setPreparedPerson(preparedPerson);
        serviceDocuments1.setNumberSheets(4);
        serviceDocuments1.setSummery("This is service document for ordering service.");

        serviceDocumentsServices.save(serviceDocuments1);


        ServiceDocuments serviceDocuments2 = new ServiceDocuments();
        serviceDocuments2.setId(2L);
        serviceDocuments2.setRegistrationNumber(102);
        serviceDocuments2.setRegistrationDate(LocalDate.now());
        serviceDocuments2.setTypeDocument("Service");
        serviceDocuments2.setStateDocument("Executing");
        serviceDocuments2.setSignedPerson(signedPerson);
        serviceDocuments2.setPreparedPerson(preparedPerson);
        serviceDocuments2.setNumberSheets(3);
        serviceDocuments2.setSummery("This is service document for ordering service.");

        serviceDocumentsServices.save(serviceDocuments2);

        System.out.println("Service Documents Loaded.....");

        Message post1 = new Message();
        post1.setId(1L);
        post1.setSubject("Telethon Institute for Child Health Research is hiring for" +
                "Bioinformatician + 20 new python jobs in Australia");
        post1.setSender("Basro Abdulle Abubakar");
        post1.setReceiver("Liban Abdullahi Mohamed");
        post1.setMessage(message());

        messageServices.save(post1);

        Message post2 = new Message();
        post2.setId(2L);
        post2.setSubject("Telethon Institute for Child Health Research is hiring for" +
                "Bioinformatician + 20 new python jobs in Australia");
        post2.setSender("Basro Abdulle Abubakar");
        post2.setReceiver("Liban Abdullahi Mohamed");
        post2.setMessage(message());

        messageServices.save(post2);
    }

    public String message(){
        return "20 new python vacancies in Australia\n" +
                "These job ads match your saved job alert *\n" +
                "\n" +
                " \n" +
                "Bioinformatician\n" +
                "Telethon Institute for Child Health Research 3.6 3.6/5 rating - Adelaide Region SA\n" +
                "$15,899 a month\n" +
                "Reporting to the Chief Data Scientist and working with other members of the Bioinformatics team, this research role will analyse datasets and develop novel…\n" +
                "1 day ago\n" +
                "GIS Specialist\n" +
                "Rio Tinto 3.9 3.9/5 rating - Australia\n" +
                "Remote\n" +
                "Build strong partnerships with a broad variety of stakeholders. Permanent full time role | Perth CBD. We are looking for a highly motivated GIS Specialist who…\n" +
                "Just posted\n" +
                "Well Architected GeoSA\n" +
                "AWS Australia Pty Ltd 3.5 3.5/5 rating - Australia\n" +
                "Hands-on experience deploying, managing and architecting workloads in a production environment. Understands large-scale complex distributed systems from an…\n" +
                "Just posted\n" +
                "2023 AIHW Graduate Program- Disability Affirmative Measures\n" +
                "AIHW Australian Institute of Health & Welfare - Australia\n" +
                "$70,271 - $76,109 a year\n" +
                "Remote\n" +
                "$70,271 – $76,109 plus superannuation. (plus 22% loading in lieu of paid leave for contract staff). Engagement Type: Ongoing, non-ongoing and contract positions…\n" +
                "2 days ago\n" +
                "Python Developer\n" +
                "Power It - Melbourne VIC\n" +
                "$90,000 - $100,000 a year\n" +
                "Qualifications Basic Bachelor’s degree or foreign equivalent required from an accredited institution. Will also consider three years of progressive experience…\n" +
                "Easily apply to this job\n" +
                "Just posted\n" +
                "Senior Systems Engineer - MECM/SCCM\n" +
                "Leidos - Adelaide Region SA\n" +
                "Proficiency with administration automation through scripting (shell, python, PowerShell). Microsoft Endpoint Configuration Manager (MECM) Engineer within an…\n" +
                "Just posted\n" +
                "Lead Compositor Sydney, Australia\n" +
                "Industrial Light & Magic - Sydney NSW\n" +
                "The Lead Compositor combines live action and computer generated elements into visual effects shots that realize the vision and creative direction of the client…\n" +
                "1 day ago\n" +
                "Data Scientists\n" +
                "CYOS Solutions 5 5/5 rating - Canberra ACT\n" +
                "$110 - $140 an hour\n" +
                "Contract extensions: One period of twelve months: 1/7/2023 to 30/6/2024 Subject to funds availability and approval. Analytical mind and business acumen.\n" +
                "Easily apply to this job\n" +
                "Just posted\n" +
                "Energy Analyst\n" +
                "VivCourt Trading - Brisbane QLD\n" +
                "A degree in Mathematics, Computer Science and/or Engineering are preferred. Advanced modelling and forecasting methodologies. Have used Python, C++, or Go.\n" +
                "Just posted\n" +
                "Engineering Manager, Managed Services\n" +
                "Canonical - Jobs - Brisbane QLD\n" +
                "Remote\n" +
                "If you have an affinity for open source development and a passion for technology, then you will enjoy working with some of the best people in the industry at…\n" +
                "1 day ago\n" +
                "Python/Django Engineer - Large Media Company\n" +
                "Opus Recruitment Solutions - Sydney NSW\n" +
                "$90,000 a year\n" +
                "Remote\n" +
                "This role has the ability to pay up to $90,000 plus super depending on your experience. This is also a remote role for Australian residents.\n" +
                "Just posted\n" +
                "GoLang Developer\n" +
                "fleet.space - Beverley SA\n" +
                "Code development for embedded systems using GoLang. Give input regarding scoping and estimation of work. Demonstrated experience coding with GoLang.\n" +
                "2 days ago\n" +
                "Azure CloudOps Engineer\n" +
                "DXC Technology 3.1 3.1/5 rating - Adelaide Region SA\n" +
                "The DXC Cloud Operations Engineer focuses on operating and maintaining the cloud environments of DXC customers as per the environment design and contractual…\n" +
                "Just posted\n" +
                "Software Engineer\n" +
                "fleet.space - Beverley SA\n" +
                "Remote\n" +
                "We are currently hiring a Senior Software Engineer to help build applications for in our cloud-based server-less infrastructure that enable customers to manage…\n" +
                "2 days ago\n" +
                "Lead Data Scientist\n" +
                "Westpac Group 3.9 3.9/5 rating - Australia\n" +
                "Temporarily Remote\n" +
                "The Data Scientist will have experience collaborating within cross-functional teams to deliver outcomes for different stakeholders.\n" +
                "Just posted\n" +
                "QA Engineer\n" +
                "Binance - Brisbane QLD\n" +
                "Remote\n" +
                "Development of scripted python tests for integration test scenarios. Binance is looking for an experienced QA Engineer (mid to senior level) to drive and…\n" +
                "Just posted\n" +
                "Data Governance Lead\n" +
                "The Royal Australian College of General Practitioners (RACGP) - Melbourne VIC\n" +
                "$120,689 - $134,275 a year\n" +
                "Remote\n" +
                "$120,689 - $134,275 PA plus 14% Super commensurate with experience. Full-time newly created permanent opportunity. Flexible location with WFH flexibility.\n" +
                "Easily apply to this job\n" +
                "Just posted\n" +
                "System Engineer\n" +
                "people2people 4.3 4.3/5 rating - Adelaide Region SA\n" +
                "Windows 7-10 Operating Systems. MS365 (Azure, Office, Intune, SharePoint, Teams). Automation scripting, Powershell, Python, Bash etc.\n" +
                "Just posted\n" +
                "Software Engineer\n" +
                "Boeing 3.9 3.9/5 rating - Adelaide CBD SA\n" +
                "Have excellent time management skills as you will need to be able to prioritise workloads and shift focus as necessary.\n" +
                "8 days ago\n" +
                "2023 AIHW Graduate Program\n" +
                "AIHW Australian Institute of Health & Welfare - Australia\n" +
                "$70,271 - $76,109 a year\n" +
                "Remote\n" +
                "$70,271 – $76,109 plus superannuation. (plus 22% loading in lieu of paid leave for contract staff). Engagement Type: Ongoing, non-ongoing and contract positions…\n" +
                "2 days ago\n" +
                "20 new vacancies\n" +
                "\n" +
                "See more jobs\n" +
                "View jobs: since yesterday - for last 7 days\n" +
                "\n" +
                "Edit this job alert\n" +
                "Salaries estimated if unavailable. When a job posting doesn't include a salary, we estimate it by looking at similar jobs. Estimated salaries are not endorsed by the companies offering those positions and may vary from actual salaries.\n" +
                "*Displayed here are Job Ads that match the job alert query you saved. Indeed may be compensated by these employers, helping keep Indeed free for job seekers. Indeed ranks Job Ads based on a combination of employer bids and relevance, such as your search terms and other activity on Indeed. For more information, see the Indeed Terms of Service\n" +
                "© 2022 Indeed Ireland Operations, Ltd.\n" +
                "124 St. Stephen's Green, Dublin 2, Ireland";
    }
}
