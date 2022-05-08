package icu.aierx.lucene;

import org.apache.commons.io.FileUtils;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.*;
import org.apache.lucene.index.*;
import org.apache.lucene.queryparser.classic.MultiFieldQueryParser;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.*;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

/**
 * @author leiwenyong
 * @since 2022/5/4
 */
public class Test1 {

    private IndexWriter getIndexWriter(boolean delete) throws IOException {
        /*
         * 第一步：创建一个indexwriter对象
         * 1指定索引库的存放位置Directory对象
         * 2指定一个分析器，对文档内容进行分析。
         */
        Directory directory = FSDirectory.open(Paths.get("C:\\Users\\aleiwe\\Desktop\\qr\\lucence\\src\\index"));
        if (delete) {
            for (String s : directory.listAll()) {
                directory.deleteFile(s);
            }
        }
        // Directory directory = new RAMDirectory();//保存索引到内存中 （内存索引库）
        // 官方推荐分词器，对中文不友好
        Analyzer analyzer = new StandardAnalyzer();
        IndexWriterConfig config = new IndexWriterConfig(analyzer);
        IndexWriter indexWriter = new IndexWriter(directory, config);
        return indexWriter;
    }

    // 创建索引
    @Test
    public void testIndex() throws Exception {
        IndexWriter indexWriter = getIndexWriter(true);

        // 第二步：通过IO读取磁盘上的文件信息
        File f = new File("C:\\Users\\aleiwe\\Desktop\\qr\\lucence\\src\\data");
        File[] listFiles = f.listFiles();
        if (listFiles != null) {
            for (File file : listFiles) {
                if (file.isFile()) {
                    // 第三步：创建document对象, 并把文件信息添加到document对象中
                    Document document = new Document();
                    // 文件名称
                    String file_name = file.getName();
                    Field fileNameField = new TextField("fileName", file_name, Field.Store.YES);
                    // 文件路径
                    String file_path = file.getPath();
                    Field filePathField = new StoredField("filePath", file_path);

                    // 文件大小
                    long file_size = FileUtils.sizeOf(file);
                    //索引
                    Field fileSizeField1 = new LongPoint("fileSize", file_size);
                    //存储
                    Field fileSizeField2 = new StoredField("fileSize", file_size);

                    // 文件内容
                    String file_content = FileUtils.readFileToString(file, "UTF-8");
                    Field fileContentField = new TextField("fileContent", file_content, Field.Store.YES);

                    document.add(fileNameField);
                    document.add(fileSizeField1);
                    document.add(fileSizeField2);
                    document.add(filePathField);
                    document.add(fileContentField);
                    // 第四步：使用indexwriter对象将document对象写入索引库，此过程进行索引创建。并将索引和document对象写入索引库。
                    indexWriter.addDocument(document);
                }
            }
            // 第五步：关闭IndexWriter对象。
            indexWriter.close();
        }
    }

    // 创建索引
    @Test
    public void testIndex2() throws Exception {
        IndexWriter indexWriter = getIndexWriter(true);
        Document document = new Document();
        // 文件名称
        Field fileNameField = new TextField("fileName", "are you ok", Field.Store.YES);
        document.add(fileNameField);
        indexWriter.addDocument(document);
        // 第五步：关闭IndexWriter对象。
        indexWriter.close();
    }

    // 搜索索引
    @Test
    public void testSearch() throws Exception {
        // 第一步：创建一个Directory对象，也就是索引库存放的位置。
        Directory directory = FSDirectory.open(Paths.get("C:\\Users\\aleiwe\\Desktop\\qr\\lucence\\src\\index"));
        // 第二步：创建一个indexReader对象，需要指定Directory对象。
        IndexReader indexReader = DirectoryReader.open(directory);
        // 第三步：创建一个indexsearcher对象，需要指定IndexReader对象
        IndexSearcher indexSearcher = new IndexSearcher(indexReader);
        // 第四步：创建一个TermQuery对象，指定查询的域和查询的关键词。
        Query query = new TermQuery(new Term("fileName", "spring.txt"));
        // 第五步：执行查询。
        TopDocs topDocs = indexSearcher.search(query, 10);
        // 第六步：返回查询结果。遍历查询结果并输出。
        ScoreDoc[] scoreDocs = topDocs.scoreDocs;
        for (ScoreDoc scoreDoc : scoreDocs) {
            int doc = scoreDoc.doc;
            Document document = indexSearcher.doc(doc);
            // 文件名称
            String fileName = document.get("fileName");
            System.out.println(fileName);
            // 文件内容
            String fileContent = document.get("fileContent");
            System.out.println(fileContent);
            // 文件大小
            String fileSize = document.get("fileSize");
            System.out.println(fileSize);
            // 文件路径
            String filePath = document.get("filePath");
            System.out.println(filePath);
            System.out.println("------------");
        }
        // 第七步：关闭IndexReader对象
        indexReader.close();
    }

    //删除fileName为albert的索引
    @Test
    public void testDelete() throws Exception {
        IndexWriter indexWriter = getIndexWriter(false);
        Query query = new TermQuery(new Term("fileName", "java.txt"));
        long l = indexWriter.deleteDocuments(query);
        indexWriter.close();
    }

    //删除全部索引
    @Test
    public void testAllDelete() throws Exception {
        // 第一步：创建一个indexwriter对象。
        Directory directory = FSDirectory.open(Paths.get("C:\\Users\\aleiwe\\Desktop\\qr\\lucence\\src\\index"));
        // 官方推荐
        Analyzer analyzer = new StandardAnalyzer();
        IndexWriterConfig config = new IndexWriterConfig(analyzer);
        IndexWriter indexWriter = new IndexWriter(directory, config);
        indexWriter.deleteAll();
        indexWriter.close();
    }

    //修改索引，把fileName为AlbertLucene.text的索引进行修改
    @Test
    public void testUpdate() throws Exception {
        Directory directory = FSDirectory.open(Paths.get("C:\\Users\\aleiwe\\Desktop\\qr\\lucence\\src\\index"));
        Analyzer analyzer = new StandardAnalyzer();
        IndexWriterConfig config = new IndexWriterConfig(analyzer);
        IndexWriter indexWriter = new IndexWriter(directory, config);
        Document doc = new Document();
        doc.add(new TextField("fileN", "testFileName111", Field.Store.YES));
        doc.add(new TextField("fileC", "testFileContent111", Field.Store.YES));
        indexWriter.updateDocument(new Term("fileName", "java.txt"), doc);
        indexWriter.close();
    }

    //创建IndexReader和IndexSearcher
    public IndexSearcher getIndexSearcher() throws Exception {
        // 第一步：创建一个Directory对象，也就是索引库存放的位置。
        Directory directory = FSDirectory.open(Paths.get("C:\\Users\\aleiwe\\Desktop\\qr\\lucence\\src\\index"));
        // 第二步：创建一个indexReader对象，需要指定Directory对象。
        IndexReader indexReader = DirectoryReader.open(directory);
        // 第三步：创建一个indexsearcher对象，需要指定IndexReader对象
        return new IndexSearcher(indexReader);
    }

    //执行查询的结果
    public void printResult(IndexSearcher indexSearcher, Query query) throws Exception {
        // 第五步：执行查询。
        TopDocs topDocs = indexSearcher.search(query, 10);
        // 第六步：返回查询结果。遍历查询结果并输出。
        ScoreDoc[] scoreDocs = topDocs.scoreDocs;
        for (ScoreDoc scoreDoc : scoreDocs) {
            int doc = scoreDoc.doc;
            Document document = indexSearcher.doc(doc);
            // 文件名称
            String fileName = document.get("fileName");
            System.out.println(fileName);
            // 文件内容
            String fileContent = document.get("fileContent");
            System.out.println(fileContent);
            // 文件路径
            String filePath = document.get("filePath");
            System.out.println(filePath);
            System.out.println("------------");
        }
    }

    //查询所有
    @Test
    public void testMatchAllDocsQuery() throws Exception {
        IndexSearcher indexSearcher = getIndexSearcher();
        Query query = new MatchAllDocsQuery();
        printResult(indexSearcher, query);
        //关闭资源
        indexSearcher.getIndexReader().close();
    }

    //根据文件大小范围查询
    @Test
    public void testRangeQuery() throws Exception {
        IndexSearcher indexSearcher = getIndexSearcher();

        Query query = LongPoint.newRangeQuery("fileSize", 0L, 8L);
        printResult(indexSearcher, query);
        //关闭资源
        indexSearcher.getIndexReader().close();
    }

    //组合查询条件
    @Test
    public void testBooleanQuery() throws Exception {
        IndexSearcher indexSearcher = getIndexSearcher();

        BooleanQuery.Builder booleanQuery = new BooleanQuery.Builder();

        Query query1 = new TermQuery(new Term("fileName", "albert"));
        Query query2 = new TermQuery(new Term("fileName", "yang"));

        booleanQuery.add(query1, BooleanClause.Occur.MUST);
        booleanQuery.add(query2, BooleanClause.Occur.SHOULD);
        System.out.println(booleanQuery);
        printResult(indexSearcher, booleanQuery.build());
        //关闭资源
        indexSearcher.getIndexReader().close();
    }

    //条件解释的对象查询
    @Test
    public void testQueryParser() throws Exception {
        IndexSearcher indexSearcher = getIndexSearcher();
        //参数1： 默认查询的域
        //参数2：采用的分析器
        QueryParser queryParser = new QueryParser("fileName", new StandardAnalyzer());
        // *:*   域：值
        Query query = queryParser.parse("fileName:lucene.txt AND fileContent:\"lucene is apache\"");

        printResult(indexSearcher, query);
        //关闭资源
        indexSearcher.getIndexReader().close();
    }

    //多域查询
    @Test
    public void testMultiFieldQueryParser() throws Exception {
        IndexSearcher indexSearcher = getIndexSearcher();

        String[] fields = {"fileName", "fileContent"};
        //参数1： 默认查询的域
        //参数2：采用的分析器
        MultiFieldQueryParser queryParser = new MultiFieldQueryParser(fields, new StandardAnalyzer());
        // *:*   域：值
        Query query = queryParser.parse("lucene.tx");
        System.out.println(query);

        printResult(indexSearcher, query);
        //关闭资源
        indexSearcher.getIndexReader().close();
    }
}
